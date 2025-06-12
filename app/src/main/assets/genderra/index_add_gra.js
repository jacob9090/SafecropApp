const survey = new Survey.Model(json);

survey.completeText = "Save Assessment";
survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateGraLocation(location) {
    survey.data.gra_location = location;
    survey.setValue('gra_location', location);
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

function sanitizeInput(value) {
    if (Array.isArray(value)) {
        return value.join(",");
    }
    return value || "";
}

survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data;
    const { graquestion1, graquestion2, graquestion3, graquestion4, graquestion5, graquestion6,
    graquestion7, graquestion8, gra_location, farmer_photo, signature } = surveyData;

    // Send the data including the raw PNG data for the signature
    Android.insertGra(
    graquestion1 || "", graquestion2 || "", graquestion3 || "", graquestion4 || "", graquestion5 || "",
    graquestion6 || "", graquestion7 || "", graquestion8 || "", gra_location || "", farmer_photo || "",
    signature || ""
    );
    Android.completeSurvey();
});

$("#surveyElement").Survey({ model: survey });
