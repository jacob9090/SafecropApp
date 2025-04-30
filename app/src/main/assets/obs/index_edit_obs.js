const survey = new Survey.Model(json);

survey.completeText = "Save Update";
survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateComLocation(location) {
    survey.data.com_location = location;
    survey.setValue('obs_location', location);
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
            surveyData.obs_name,
            surveyData.obs_district,
            surveyData.obs_community,
            surveyData.obsquestion6,
            surveyData.obsquestion7,
            surveyData.obsquestion8,
            surveyData.obsquestion9,
            surveyData.obsquestion10,
            surveyData.obsquestion11,
            surveyData.obsquestion12,
            surveyData.obsquestion13,
            surveyData.obsquestion14,
            surveyData.obsquestion15,
            surveyData.obsquestion16,
            surveyData.obsquestion17,
            surveyData.obsquestion18,
            surveyData.obsquestion19,
            surveyData.obsquestion20,
            surveyData.obsquestion21,
            surveyData.obs_location
        );
    }
});

$("#surveyElement").Survey({ model: survey });
