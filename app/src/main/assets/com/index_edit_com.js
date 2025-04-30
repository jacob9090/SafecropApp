const survey = new Survey.Model(json);

survey.completeText = "Save Update";
survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateComLocation(location) {
    survey.data.com_location = location;
    survey.setValue('com_location', location);
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
            surveyData.commquestion1,
            surveyData.commquestion2,
            surveyData.commquestion3,
            surveyData.commquestion4,
            surveyData.commquestion5,
            surveyData.commquestion6,
            surveyData.commquestion7,
            surveyData.commquestion8,
            surveyData.commquestion9,
            surveyData.commquestion10,
            surveyData.commquestion11,
            surveyData.commquestion12,
            surveyData.commquestion13,
            surveyData.commquestion14,
            surveyData.commquestion15,
            surveyData.commquestion16,
            surveyData.commquestion17,
            surveyData.commquestion18,
            surveyData.commquestion19,
            surveyData.commquestion20,
            surveyData.commquestion21,
            surveyData.commquestion22,
            surveyData.commquestion23,
            surveyData.commquestion24,
            surveyData.commquestion25,
            surveyData.commquestion26,
            surveyData.commquestion27,
            surveyData.commquestion28,
            surveyData.commquestion29,
            surveyData.commquestion30,
            surveyData.commquestion31,
            surveyData.commquestion32,
            surveyData.commquestion33,
            surveyData.commquestion34,
            surveyData.commquestion35,
            surveyData.commquestion36,
            surveyData.commquestion37,
            surveyData.commquestion38,
            surveyData.commquestion39,
            surveyData.commquestion40,
            surveyData.commquestion41,
            surveyData.commquestion42,
            surveyData.commquestion43,
            surveyData.commquestion44,
            surveyData.commquestion45,
            surveyData.commquestion46,
            surveyData.commquestion47,
            surveyData.commquestion48,
            surveyData.commquestion49,
            surveyData.commquestion50,
            surveyData.commquestion51,
            surveyData.commquestion52,
            surveyData.commquestion53,
            surveyData.commquestion54,
            surveyData.commquestion56,
            surveyData.commquestion57,
            surveyData.commquestion58,
            surveyData.commquestion59,
            surveyData.commquestion60,
            surveyData.commquestion61,
            surveyData.commquestion62,
            surveyData.commquestion63,
            surveyData.commquestion64,
            surveyData.commquestion65,
            surveyData.commquestion66,
            surveyData.commquestion67,
            surveyData.com_location
        );
    }
});

$("#surveyElement").Survey({ model: survey });
