const survey = new Survey.Model(json);

survey.completeText = "Update Inspection";
survey.showCompletedPage = false;

// Store original photo and signature for fallback
window._original_farmer_photo = "";
window._original_signature = "";

// Prefill all survey fields (called from Java after page load)
window.prefillInspection = function(data) {
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
function updateInspectionLocation(location) {
    survey.setValue('inspection_location', location);
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

    Android.updateInspection(
        data.farmer_id || "",
        data.farmer_name || "",
        data.district || "",
        data.community || "",
        data.ghana_card || "",
        data.farmer_yob || "",
        data.farmer_phone || "",
        data.farmer_gender || "",
        data.inspection_date || "",
        data.inspector_name || "",
        data.inspection_question1 || "",
        data.inspection_question1b || "",
        data.inspection_question2 || "",
        data.inspection_question2b || "",
        data.inspection_question3 || "",
        data.inspection_question3b || "",
        data.inspection_question4 || "",
        data.inspection_question4b || "",
        data.inspection_question5 || "",
        data.inspection_question5b || "",
        data.inspection_question6 || "",
        data.inspection_question6b || "",
        data.inspection_question7 || "",
        data.inspection_question7b || "",
        data.inspection_question8 || "",
        data.inspection_question8b || "",
        data.inspection_question9 || "",
        data.inspection_question9b || "",
        data.inspection_question10 || "",
        data.inspection_question10b || "",
        data.inspection_question11 || "",
        data.inspection_question11b || "",
        data.inspection_question12 || "",
        data.inspection_question12b || "",
        data.inspection_question13 || "",
        data.inspection_question13b || "",
        data.inspection_question14 || "",
        data.inspection_question14b || "",
        data.inspection_question15 || "",
        data.inspection_question15b || "",
        data.inspection_question16 || "",
        data.inspection_question16b || "",
        data.inspection_question17 || "",
        data.inspection_question17b || "",
        data.inspection_question18 || "",
        data.inspection_question18b || "",
        data.inspection_question19 || "",
        data.inspection_question19b || "",
        data.inspection_question20 || "",
        data.inspection_question20b || "",
        data.inspection_question21 || "",
        data.inspection_question21b || "",
        data.inspection_question22 || "",
        data.inspection_question22b || "",
        data.inspection_question23 || "",
        data.inspection_question23b || "",
        data.inspection_question24 || "",
        data.inspection_question24b || "",
        data.inspection_question25 || "",
        data.inspection_question25b || "",
        data.inspection_question26 || "",
        data.inspection_question26b || "",
        data.inspection_question27 || "",
        data.inspection_question27b || "",
        data.inspection_question28 || "",
        data.inspection_question28b || "",
        data.inspection_question29 || "",
        data.inspection_question29b || "",
        data.inspection_question30 || "",
        data.inspection_question30b || "",
        data.inspection_question31 || "",
        data.inspection_question31b || "",
        data.inspection_question32 || "",
        data.inspection_question32b || "",
        data.inspection_question33 || "",
        data.inspection_question33b || "",
        data.inspection_question34 || "",
        data.inspection_question34b || "",
        data.inspection_question35 || "",
        data.inspection_question35b || "",
        data.inspection_question36 || "",
        data.inspection_question36b || "",
        data.inspection_question37 || "",
        data.inspection_question37b || "",
        data.inspection_question38 || "",
        data.inspection_question38b || "",
        data.inspection_question39 || "",
        data.inspection_question39b || "",
        data.inspection_question40 || "",
        data.inspection_question40b || "",
        data.inspection_question41 || "",
        data.inspection_question41b || "",
        data.inspection_question42 || "",
        data.inspection_question42b || "",
        data.inspection_question43 || "",
        data.inspection_question43b || "",
        data.inspection_question44 || "",
        data.inspection_question44b || "",
        data.inspection_question45 || "",
        data.inspection_question45b || "",
        data.inspection_question46 || "",
        data.inspection_question46b || "",
        data.inspection_question47 || "",
        data.inspection_question47b || "",
        data.inspection_question48 || "",
        data.inspection_question48b || "",
        data.inspection_question49 || "",
        data.inspection_question49b || "",
        data.inspection_question50 || "",
        data.inspection_question50b || "",
        data.inspection_question51 || "",
        data.inspection_question51b || "",
        data.inspection_question52 || "",
        data.inspection_question52b || "",
        data.inspection_question53 || "",
        data.inspection_question53b || "",
        data.inspection_question54 || "",
        data.inspection_question54b || "",
        data.inspection_question55 || "",
        data.inspection_question55b || "",
        data.inspection_question56 || "",
        data.inspection_question56b || "",
        data.inspection_question57 || "",
        data.inspection_question57b || "",
        data.inspection_question58 || "",
        data.inspection_question58b || "",
        data.inspection_location || "",
        farmer_photo,
        signature,
        is_sync,
        "0" // is_draft
    );
});

// Called from Android with the inspectionModel JSON
window.prefillInspection = function(model) {
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