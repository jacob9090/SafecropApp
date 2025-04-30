const survey = new Survey.Model(json);

survey.completeText = "Save Survey";
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

function populateSurveyFields(farmerId, farmerDistrict, farmerVillage) {
    survey.setValue('hh_name', farmerId);
    survey.setValue('hh_district', farmerDistrict);
    survey.setValue('hh_community', farmerVillage);
}

function sanitizeInput(value) {
    if (Array.isArray(value)) {
        return value.join(",");
    }
    return value || ""; // Return value if it's a string, else return an empty string
}

survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data;
    const { hh_name, hh_district, hh_community,
    hhquestion4, hhquestion5, hhquestion6, hhquestion7, hhquestion8, hhquestion9, hhquestion10, hhquestion11,
    hhquestion12, hhquestion13, hhquestion14, hhquestion15, hhquestion16, hhquestion17, hhquestion18, hhquestion19,
    hhquestion20, hhquestion21, hhquestion22, hhquestion23, hhquestion24, hhquestion25, hhquestion26, hhquestion27,
    hhquestion28, hhquestion29, hhquestion30, hhquestion31, hhquestion32, hhquestion36, hhquestion37,
    hh_location, farmer_photo, signature } = surveyData;

    // Send the data including the raw PNG data for the signature
    Android.insertHh(
    hh_name || "", hh_district || "", hh_community || "", hhquestion4 || "", hhquestion5 || "",
    hhquestion6 || "", hhquestion7 || "", hhquestion8 || "", hhquestion9 || "", hhquestion10 || "",
    hhquestion11 || "", hhquestion12 || "", hhquestion13 || "", hhquestion14 || "", hhquestion15 || "",
    hhquestion16 || "", hhquestion17 || "", hhquestion18 || "", hhquestion19 || "", hhquestion20 || "",
    hhquestion21 || "", hhquestion22 || "", hhquestion23 || "", hhquestion24 || "", hhquestion25 || "",
    hhquestion26 || "", hhquestion27 || "", hhquestion28 || "", hhquestion29 || "", hhquestion30 || "",
    hhquestion31 || "", hhquestion32 || "", hhquestion36 || "", hhquestion37 || "",
    hh_location || "", farmer_photo || "", signature || ""
    );
    Android.completeSurvey();
});

// Render the survey
$("#surveyElement").Survey({ model: survey });
