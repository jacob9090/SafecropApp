const survey = new Survey.Model(json);

survey.completeText = "Save Update";
survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateComLocation(location) {
    survey.data.com_location = location;
    survey.setValue('org_location', location);
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

// Fetch saved data from Android
document.addEventListener("DOMContentLoaded", function () {
    if (window.Android && typeof window.Android.getSavedData === "function") {
        const savedData = JSON.parse(window.Android.getSavedData());
        if (savedData) {
            survey.data = savedData; // Populate form fields with saved data
        }
    }
});

// Handle survey completion
survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data;

    // Send the updated data back to Android
    if (window.Android && typeof window.Android.saveUpdatedData === "function") {
        Android.saveUpdatedData(
            surveyData.orgquestion1,
            surveyData.orgquestion2,
            surveyData.orgquestion3,
            surveyData.orgquestion4,
            surveyData.orgquestion5,
            surveyData.orgquestion6,
            surveyData.orgquestion7,
            surveyData.orgquestion8,
            surveyData.orgquestion9,
            surveyData.orgquestion10,
            surveyData.orgquestion11,
            surveyData.orgquestion12,
            surveyData.orgquestion13,
            surveyData.orgquestion14,
            surveyData.orgquestion15,
            surveyData.orgquestion16,
            surveyData.orgquestion17,
            surveyData.orgquestion18,
            surveyData.orgquestion19,
            surveyData.orgquestion20,
            surveyData.orgquestion21,
            surveyData.orgquestion22,
            surveyData.orgquestion23,
            surveyData.orgquestion24,
            surveyData.orgquestion25,
            surveyData.orgquestion26,
            surveyData.orgquestion27,
            surveyData.orgquestion28,
            surveyData.orgquestion29,
            surveyData.orgquestion30,
            surveyData.orgquestion31,
            surveyData.org_location
        );
    }
});

$("#surveyElement").Survey({ model: survey });