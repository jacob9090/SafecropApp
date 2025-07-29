const survey = new Survey.Model(json);

survey.completeText = "Update Profiling";
survey.showCompletedPage = false;

// Store original photo and signature for fallback
window._original_farmer_photo = "";
window._original_signature = "";

// Prefill all survey fields (called from Java after page load)
window.prefillSusProfiling = function(data) {
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
function updateProfilingLocation(location) {
    survey.setValue('suspro_location', location);
}
function handleGetFarmerPhoto() {
    Android.openFarmerPhotoActivity();
}
function updateFarmerPhoto(photoFarmerUri) {
    const photoFarmerImg = document.getElementById('FarmerPhotoDisplay');
    if (photoFarmerImg) {
        photoFarmerImg.src = photoFarmerUri;
    }
    survey.setValue('farmer_photo', photoFarmerUri);
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

    Android.updateSusProfiling(
        data.farmer_id || "",
        data.district || "",
        data.community || "",
        data.suspro_question1 || "",
        data.suspro_question2 || "",
        data.suspro_question3 || "",
        data.suspro_question4 || "",
        data.suspro_question4b || "",
        data.suspro_question4c || "",
        data.suspro_question5 || "",
        data.suspro_question6 || "",
        data.suspro_question7 || "",
        data.suspro_question7b || "",
        data.suspro_question8 || "",
        data.suspro_question8b || "",
        data.suspro_question9 || "",
        data.suspro_question10 || "",
        data.suspro_question11 || "",
        data.suspro_question11b || "",
        data.suspro_question11c || "",
        data.suspro_question12 || "",
        data.suspro_question12b || "",
        data.suspro_question13 || "",
        data.suspro_question14 || "",
        data.suspro_question14b || "",
        data.suspro_question14c || "",
        data.suspro_question14d || "",
        data.suspro_question15 || "",
        data.suspro_question15b || "",
        data.suspro_question16 || "",
        data.suspro_question16b || "",
        data.suspro_question17 || "",
        data.suspro_question17b || "",
        data.suspro_question17c || "",
        data.suspro_question18 || "",
        data.suspro_question19 || "",
        data.suspro_question20 || "",
        data.suspro_question21 || "",
        data.suspro_location || "",
        farmer_photo,
        signature,
        is_sync,
        "0" // is_draft
    );
});

// Called from Android with the profilingModel JSON
window.prefillSusProfiling = function(model) {
    if (!model) return;
    // Fill fields from model
    for (const key in model) {
        if (model.hasOwnProperty(key)) {
            // Use setValue for known survey fields
            if (survey.getQuestionByName(key)) {
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