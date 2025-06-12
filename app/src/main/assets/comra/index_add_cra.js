const survey = new Survey.Model(json);

survey.completeText = "Save Assessment";
survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateCraLocation(location) {
    survey.data.cra_location = location;
    survey.setValue('cra_location', location);
}

function sanitizeInput(value) {
    if (Array.isArray(value)) {
        return value.join(",");
    }
    return value || ""; // Return value if it's a string, else return an empty string
}

survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data;
    const { craquestion1, craquestion2, craquestion3, craquestion4, craquestion5, craquestion6,
    craquestion7, craquestion8, craquestion9, craquestion10, craquestion11, craquestion12, craquestion13,
     cra_location } = surveyData;

    // Send the data including the raw PNG data for the signature
    Android.insertSurveyData(
    craquestion1 || "", craquestion2 || "", craquestion3 || "", craquestion4 || "", craquestion5 || "",
    craquestion6 || "", craquestion7 || "", craquestion8 || "", craquestion9 || "", craquestion10 || "",
    craquestion11 || "", craquestion12 || "", craquestion13 || "", cra_location || ""
    );
    Android.completeSurvey();
});

// Render the survey
$("#surveyElement").Survey({ model: survey });
