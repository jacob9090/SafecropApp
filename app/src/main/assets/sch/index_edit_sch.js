const survey = new Survey.Model(json);

survey.completeText = "Save Update";
survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateComLocation(location) {
    survey.data.com_location = location;
    survey.setValue('sch_location', location);
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
            surveyData.sch_name,
            surveyData.sch_district,
            surveyData.sch_community,
            surveyData.schquestion4,
            surveyData.schquestion5,
            surveyData.schquestion6,
            surveyData.schquestion7,
            surveyData.schquestion8,
            surveyData.schquestion9,
            surveyData.schquestion10,
            surveyData.schquestion11,
            surveyData.schquestion12,
            surveyData.schquestion13,
            surveyData.schquestion14,
            surveyData.schquestion15,
            surveyData.schquestion16,
            surveyData.schquestion17,
            surveyData.schquestion18,
            surveyData.schquestion19,
            surveyData.schquestion20,
            surveyData.schquestion21,
            surveyData.schquestion22,
            surveyData.schquestion23,
            surveyData.schquestion24,
            surveyData.schquestion25,
            surveyData.schquestion26,
            surveyData.schquestion27,
            surveyData.schquestion28,
            surveyData.schquestion29,
            surveyData.schquestion30,
            surveyData.schquestion31,
            surveyData.schquestion32,
            surveyData.schquestion33,
            surveyData.schquestion34,
            surveyData.sch_location
        );
    }
});

$("#surveyElement").Survey({ model: survey });
