const survey = new Survey.Model(json);

survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateChildLocation(location) {
    survey.data.child_location = location;
    survey.setValue('child_location', location);
}

function populateSurveyFields(district, community, farmer_id, child_location) {
    survey.setValue('farmer_district', district);
    survey.setValue('farmer_community', community);
    survey.setValue('farmer_id', farmer_id);
    survey.setValue('child_location', child_location);
}

survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data;
    const { farmer_district, farmer_community, farmer_id, child_location } = surveyData;

    // Send updated data to Android (without signature)
    Android.updateSurveyData(
        farmer_district, farmer_community, farmer_id, child_location
    );
    Android.completeSurvey();
});

// Render the survey
$("#surveyElement").Survey({ model: survey });
