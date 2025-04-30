const survey = new Survey.Model(json);

survey.completeText = "Save Survey";
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

function sanitizeInput(value) {
    if (Array.isArray(value)) {
        return value.join(",");
    }
    return value || ""; // Return value if it's a string, else return an empty string
}

survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data || {};
    const { commquestion1, commquestion2, commquestion3, commquestion4, commquestion5, commquestion6, commquestion7,
    commquestion8, commquestion9, commquestion10, commquestion11, commquestion12, commquestion13, commquestion14,
    commquestion15, commquestion16, commquestion17, commquestion18, commquestion19, commquestion20, commquestion21,
    commquestion22, commquestion23, commquestion24, commquestion25, commquestion26, commquestion27, commquestion28,
    commquestion29, commquestion30, commquestion31, commquestion32, commquestion33, commquestion34, commquestion35,
    commquestion36, commquestion37, commquestion38, commquestion39, commquestion40, commquestion41, commquestion42,
    commquestion43, commquestion44, commquestion45, commquestion46, commquestion47, commquestion48, commquestion49,
    commquestion50, commquestion51, commquestion52, commquestion53, commquestion54, commquestion56, commquestion57,
    commquestion58, commquestion59, commquestion60, commquestion61, commquestion62, commquestion63, commquestion64,
    commquestion65, commquestion66, commquestion67, com_location, farmer_photo, signature } = surveyData;

    // Send the data including the raw PNG data for the signature
    Android.insertCom(
    commquestion1 || "", commquestion2 || "", commquestion3 || "", commquestion4 || "", commquestion5 || "",
    commquestion6 || "", commquestion7 || "", commquestion8 || "", commquestion9 || "", sanitizeInput(commquestion10),
    commquestion11 || "", commquestion12 || "", commquestion13 || "", commquestion14 || "", commquestion15 || "",
    commquestion16 || "", commquestion17 || "", commquestion18 || "", commquestion19 || "", commquestion20 || "",
    commquestion21 || "", commquestion22 || "", commquestion23 || "", commquestion24 || "", commquestion25 || "",
    commquestion26 || "", commquestion27 || "", commquestion28 || "", sanitizeInput(commquestion29), commquestion30 || "",
    sanitizeInput(commquestion31), commquestion32 || "", commquestion33 || "", commquestion34 || "", commquestion35 || "",
    commquestion36 || "", commquestion37 || "", commquestion38 || "", commquestion39 || "", commquestion40 || "",
    commquestion41 || "", commquestion42 || "", commquestion43 || "", commquestion44 || "", commquestion45 || "",
    commquestion46 || "", commquestion47 || "", sanitizeInput(commquestion48), commquestion49 || "", commquestion50 || "",
    commquestion51 || "", commquestion52 || "", commquestion53 || "", commquestion54 || "", commquestion56 || "",
    sanitizeInput(commquestion57), commquestion58 || "", commquestion59 || "", commquestion60 || "", commquestion61 || "",
    commquestion62 || "", commquestion63 || "", commquestion64 || "", commquestion65 || "", commquestion66 || "",
    commquestion67 || "", com_location || "", farmer_photo || "", signature || ""
    );
    Android.completeSurvey();
});

$("#surveyElement").Survey({ model: survey });
