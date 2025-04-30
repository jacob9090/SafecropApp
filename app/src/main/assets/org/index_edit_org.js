const survey = new Survey.Model(json);

survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateChildLocation(location) {
    survey.data.child_location = location;
    survey.setValue('child_location', location);
}

function populateSurveyFields(farmerId, farmerDistrict, farmerVillage, childLocation) {
    survey.setValue('farmer_id', farmerId);
    survey.setValue('farmer_district', farmerDistrict);
    survey.setValue('farmer_village', farmerVillage);
    survey.setValue('child_location', childLocation);
}

survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data;
    const { farmer_id, farmer_district, farmer_village, child_location } = surveyData;

    // Send updated data to Android (without signature)
    Android.updateSurveyData(
        farmer_id, farmer_district, farmer_village, child_location
    );
    Android.completeSurvey();
});

// Render the survey
$("#surveyElement").Survey({ model: survey });
