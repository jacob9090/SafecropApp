const survey = new Survey.Model(json);

survey.completeText = "Save Survey";
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

function populateSurveyFields(district, community, farmer_id) {
    survey.setValue('obs_district', district);
    survey.setValue('obs_community', community);
    survey.setValue('obs_name', farmer_id);
}

function sanitizeInput(value) {
    if (Array.isArray(value)) {
        return value.join(",");
    }
    return value || ""; // Return value if it's a string, else return an empty string
}

survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data;
    const { obs_name, obs_district, obs_community,
    obsquestion6, obsquestion7, obsquestion8, obsquestion9, obsquestion10, obsquestion11, obsquestion12, obsquestion13,
    obsquestion14, obsquestion15, obsquestion16, obsquestion17, obsquestion18, obsquestion19, obsquestion20,
    obsquestion21, obs_location, farmer_photo, signature } = surveyData;

    // Send the data including the raw PNG data for the signature
    Android.insertObs(
    obs_name || "", obs_district || "", obs_community || "",
    obsquestion6 || "", obsquestion7 || "", obsquestion8 || "", obsquestion9 || "", obsquestion10 || "",
    obsquestion11 || "", obsquestion12 || "", obsquestion13 || "", obsquestion14 || "", obsquestion15 || "",
    obsquestion16 || "", obsquestion17 || "", obsquestion18 || "", obsquestion19 || "", obsquestion20 || "",
    obsquestion21 || "", obs_location || "", farmer_photo || "", signature || ""
    );
    Android.completeSurvey();
});

$("#surveyElement").Survey({ model: survey });
