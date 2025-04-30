const survey = new Survey.Model(json);

survey.completeText = "Save Survey";
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

function sanitizeInput(value) {
    if (Array.isArray(value)) {
        return value.join(",");
    }
    return value || ""; // Return value if it's a string, else return an empty string 024 424 1700
}

survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data;
    const { sch_name, sch_district, sch_community,
    schquestion4, schquestion5, schquestion6, schquestion7, schquestion8, schquestion9, schquestion10,
    schquestion11, schquestion12, schquestion13, schquestion14, schquestion15, schquestion16, schquestion17,
    schquestion18, schquestion19, schquestion20, schquestion21, schquestion22, schquestion23, schquestion24,
    schquestion25, schquestion26, schquestion27, schquestion28, schquestion29, schquestion30, schquestion31,
    schquestion32, schquestion33, schquestion34, sch_location, farmer_photo, signature } = surveyData;

    // Send the data including the raw PNG data for the signature
    Android.insertSchool(
    sch_name || "", sch_district || "", sch_community || "", schquestion4 || "", schquestion5 || "",
    schquestion6 || "", schquestion7 || "", schquestion8 || "", schquestion9 || "", schquestion10 || "",
    schquestion11 || "", schquestion12 || "", schquestion13 || "", schquestion14 || "", schquestion15 || "",
    schquestion16 || "", schquestion17 || "", schquestion18 || "", schquestion19 || "", schquestion20 || "",
    schquestion21 || "", schquestion22 || "", schquestion23 || "", schquestion24 || "", schquestion25 || "",
    schquestion26 || "", schquestion27 || "", sanitizeInput(schquestion28), schquestion29 || "", schquestion30 || "",
    schquestion31 || "", schquestion32 || "", schquestion33 || "", schquestion34 || "",
    sch_location || "", farmer_photo || "", signature || ""
    );
    Android.completeSurvey();
});

$("#surveyElement").Survey({ model: survey });

