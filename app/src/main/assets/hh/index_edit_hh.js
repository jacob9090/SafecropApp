const survey = new Survey.Model(json);

survey.completeText = "Save Update";
survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateComLocation(location) {
    survey.data.com_location = location;
    survey.setValue('hh_location', location);
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
            surveyData.hh_name,
            surveyData.hh_district,
            surveyData.hh_community,
            surveyData.hhquestion4,
            surveyData.hhquestion5,
            surveyData.hhquestion6,
            surveyData.hhquestion7,
            surveyData.hhquestion8,
            surveyData.hhquestion9,
            surveyData.hhquestion10,
            surveyData.hhquestion11,
            surveyData.hhquestion12,
            surveyData.hhquestion13,
            surveyData.hhquestion14,
            surveyData.hhquestion15,
            surveyData.hhquestion16,
            surveyData.hhquestion17,
            surveyData.hhquestion18,
            surveyData.hhquestion19,
            surveyData.hhquestion20,
            surveyData.hhquestion21,
            surveyData.hhquestion22,
            surveyData.hhquestion23,
            surveyData.hhquestion24,
            surveyData.hhquestion25,
            surveyData.hhquestion26,
            surveyData.hhquestion27,
            surveyData.hhquestion28,
            surveyData.hhquestion29,
            surveyData.hhquestion30,
            surveyData.hhquestion31,
            surveyData.hhquestion32,
            surveyData.hhquestion36,
            surveyData.hhquestion37,
            surveyData.hh_location
        );
    }
});

$("#surveyElement").Survey({ model: survey });
