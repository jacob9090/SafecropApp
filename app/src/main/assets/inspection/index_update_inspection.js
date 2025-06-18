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
        data.inspection_question1 || "",
        data.inspection_question2 || "",
        data.inspection_question3 || "",
        data.inspection_question4 || "",
        data.inspection_question5 || "",
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






//const survey = new Survey.Model(json);
//
//survey.completeText = "Update Inspection";
//survey.showCompletedPage = false;
//
//// Prefill all survey fields (called from Java after page load)
//window.prefillInspection = function(data) {
//    if (typeof data === "string") data = JSON.parse(data);
//    Object.keys(data).forEach(key => {
//        if (typeof data[key] !== 'undefined' && survey.getQuestionByName(key)) {
//            survey.setValue(key, data[key]);
//        }
//    });
//};
//
//function handleGetLocation() {
//    Android.openLocationActivity();
//}
//function updateInspectionLocation(location) {
//    survey.setValue('inspection_location', location);
//}
//function handleGetFarmerPhoto() {
//    Android.openFarmerPhotoActivity();
//}
//function updateFarmerPhoto(photoFarmerUri) {
//    const photoFarmerImg = document.getElementById('FarmerPhotoDisplay');
//    if (photoFarmerImg) {
//        photoFarmerImg.src = photoFarmerUri;
//    }
//}
//
//function notifyAndroidPageLoaded() {
//    if (window.Android) {
//        Android.notifyPageLoaded();
//    }
//}
//
//document.addEventListener("DOMContentLoaded", function () {
//    $("#surveyElement").Survey({ model: survey });
//    notifyAndroidPageLoaded();
//});
//
//survey.onComplete.add(function (survey, options) {
//    const data = survey.data;
//    const is_sync = "0";
//    // Update record in DB
//    Android.updateInspection(
//        data.farmer_id || "",
//        data.farmer_name || "",
//        data.district || "",
//        data.community || "",
//        data.inspection_question1 || "",
//        data.inspection_question2 || "",
//        data.inspection_question3 || "",
//        data.inspection_question4 || "",
//        data.inspection_question5 || "",
//        data.inspection_location || "",
//        data.farmer_photo ? data.farmer_photo : "",
//        data.signature ? data.signature : "",
//        is_sync,
//        "0" // is_draft
//    );
//});