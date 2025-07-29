const survey = new Survey.Model(json);

survey.completeText = "Update Training";
survey.showCompletedPage = false;

// Store original photo and signature for fallback
window._original_farmer_photo = "";
window._original_signature = "";

// Prefill all survey fields (called from Java after page load)
window.prefillTraining = function(data) {
    if (typeof data === "string") data = JSON.parse(data);
    Object.keys(data).forEach(key => {
        if (typeof data[key] !== 'undefined' && survey.getQuestionByName(key)) {
            survey.setValue(key, data[key]);
        }
    });
    window._original_farmer_photo = data.farmer_photo || "";
    window._original_signature = data.signature || "";
};

function handleGetLocation() {
    Android.openLocationActivity();
}
function updateTrainingLocation(location) {
    survey.setValue('training_location', location);
}
function handleGetFarmerPhoto() {
    Android.openFarmerPhotoActivity();
}
function updateFarmerPhoto(photoFarmerUri) {
    const photoFarmerImg = document.getElementById('FarmerPhotoDisplay');
    if (photoFarmerImg) {
        photoFarmerImg.src = photoFarmerUri;
    }
    survey.setValue('farmer_photo', photoFarmerUri); // Ensure it's in the survey data!
}

function notifyAndroidPageLoaded() {
    if (window.Android) {
        Android.notifyPageLoaded();
    }
}

document.addEventListener("DOMContentLoaded", function () {
    $("#surveyElement").Survey({ model: survey });
    notifyAndroidPageLoaded();
});

function sanitizeInput(value) {
    if (Array.isArray(value)) {
        return value.join(",");
    }
    return value || "";
}

survey.onComplete.add(function (survey, options) {
    const data = survey.data;
    const is_sync = "0";
    // Fallback to old photo/signature if new one not provided
    const farmer_photo = (data.farmer_photo && data.farmer_photo.length > 0)
        ? data.farmer_photo
        : window._original_farmer_photo || "";
    const signature = (data.signature && data.signature.length > 0)
        ? data.signature
        : window._original_signature || "";

    Android.updateTraining(
        data.training_code || "",
        data.district || "",
        data.community || "",
        data.training_question1 || "",
        data.training_question2 || "",
        data.training_question3 || "",
        data.training_question4 || "",
        data.training_question5 || "",
        sanitizeInput(data.training_question6),
        data.training_question7 || "",
        data.training_question8 || "",
        data.training_question9 || "",
        data.training_question10 || "",
        data.training_question11 || "",
        data.training_question12 || "",
        data.training_question13 || "",
        data.training_question14 || "",
        data.training_question15 || "",
        data.training_location || "",
        data.farmer_photo || "",
        data.signature ? data.signature : null,
        is_sync,
        "0" // is_draft
    );
});

// Called from Android with the trainingModel JSON
window.prefillTraining = function(model) {
    if (!model) return;
    // Fill fields from model
    for (const key in model) {
        if (model.hasOwnProperty(key)) {
            // Use setValue for known survey fields
            if (key === "training_question6" && typeof model[key] === "string") {
                survey.setValue(key, model[key].split(",").map(s => s.trim()).filter(Boolean));
            } else {
                survey.setValue(key, model[key]);
            }
        }
    }
    // Farmer Photo
    if (model.farmer_photo) {
        let img = document.getElementById("FarmerPhotoDisplay");
        if (img) img.src = model.farmer_photo;
    }
    // Signature - expects base64, not file path!
    if (model.signature) {
        // If it's already base64, just set it.
        if (model.signature.startsWith("data:image")) {
            survey.setValue("signature", model.signature);
        } else if (model.signature.startsWith("/")) {
            // It's a file path - need to ask Android to read the file and send back base64
            if (window.Android && Android.getSignatureBase64) {
                Android.getSignatureBase64(model.signature);
            }
        }
    }
};