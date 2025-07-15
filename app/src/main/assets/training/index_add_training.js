const survey = new Survey.Model(json);

survey.completeText = "Save Training";
survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateInspectionLocation(location) {
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
}

// Match keys with Java
function populateSurveyFields(farmer_id, farmer_name, gender, district, community, plot_id) {
    survey.setValue('farmer_id', farmer_id);
    survey.setValue('farmer_name', farmer_name);
    survey.setValue('gender', gender);
    survey.setValue('district', district);
    survey.setValue('community', community);
    survey.setValue('plot_id', plot_id);
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

function saveInspection(isDraft) {
    const data = survey.data;
    const is_sync = "0";
    Android.insertOrUpdateInspection(
        data.training_code || "",
        data.district || "",
        data.community || "",
        data.training_question1 || "",
        data.training_question2 || "",
        data.training_question3 || "",
        data.training_question4 || "",
        data.training_question5 || "",
        data.training_question6 || "",
        data.training_question7 || "",
        data.training_question8 || "",
        data.training_question9 || "",
        data.training_question10 || "",
        data.training_question11 || "",
        data.training_question12 || "",
        data.training_question13 || "",
        data.training_question14 || "",
        data.training_question15 || "",
        data.training_question16 || "",
        data.inspection_location || "",
        data.farmer_photo || "",
        data.signature ? data.signature : null,
        is_sync,
        isDraft ? "1" : "0"
    );
    if (!isDraft) {
        Android.completeSurvey();
    }
}

// Only trigger on explicit user actions:
// - For final save: via SurveyJS completion event
survey.onComplete.add(function (survey, options) {
    saveInspection(false);
});
