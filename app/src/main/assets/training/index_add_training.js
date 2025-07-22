const survey = new Survey.Model(json);

survey.completeText = "Save Training";
survey.showCompletedPage = false;

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
}

// Match keys with Java
function setTraining_code(training_code) {
    survey.setValue('training_code', training_code);
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

function saveTraining(isDraft) {
    const data = survey.data;
    const is_sync = "0";
    Android.insertOrUpdateTraining(
        data.training_code || "",
        data.district || "",
        data.community || "",
        data.train_question1 || "",
        data.train_question2 || "",
        data.train_question3 || "",
        data.train_question4 || "",
        data.train_question5 || "",
        data.train_question6 || "",
        data.train_question7 || "",
        data.training_location || "",
        data.farmer_photo || "",
        data.signature ? data.signature : null,
        data.train_question8 || "",
        data.train_question9 || "",
        data.train_question10 || "",
        data.train_question11 || "",
        data.train_question12 || "",
        data.train_question13 || "",
        data.train_question14 || "",
        data.train_question15 || "",
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
    saveTraining(false);
});
