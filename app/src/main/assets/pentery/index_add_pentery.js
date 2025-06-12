const survey = new Survey.Model(json);

survey.completeText = "Save Entry";
survey.showCompletedPage = false;

function handleGetFarmerPhoto() {
    Android.openFarmerPhotoActivity();
}

function updateFarmerPhoto(photoFarmerUri) {
    const photoFarmerImg = document.getElementById('FarmerPhotoDisplay');
    if (photoFarmerImg) {
        photoFarmerImg.src = photoFarmerUri;
    }
}

function setPequestion14(uniqueCode) {
    survey.setValue('pequestion14', uniqueCode);
}

function setPequestion5(ghCad) {
    console.log("setPequestion5 called with:", ghCad);
    survey.setValue('pequestion5', ghCad);
}

function notifyAndroidPageLoaded() {
    if (window.Android) {
        Android.notifyPageLoaded();
    }
}

document.addEventListener("DOMContentLoaded", function () {
    $("#surveyElement").Survey({ model: survey });
    notifyAndroidPageLoaded();
});

function sanitizeInput(value) {
    if (Array.isArray(value)) {
        return value.join(",");
    }
    return value || "";
}

survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data;
    let {
        pequestion1, pequestion2, pequestion3, pequestion4, pequestion5,
        pequestion6, pequestion7, pequestion8, pequestion9, pequestion10,
        pequestion11, pequestion12, pequestion13, pequestion14, farmer_photo
    } = surveyData;

    // --- HANDLING MULTIPLE 'Other' fields ---

    // Handle pequestion1 (District)
    if (surveyData['pequestion1-Comment'] && surveyData['pequestion1-Comment'].trim() !== '') {
        pequestion1 = surveyData['pequestion1-Comment'];
    } else {
        pequestion1 = pequestion1 || "";
    }

    // Handle pequestion2 (Community)
    if (surveyData['pequestion2-Comment'] && surveyData['pequestion2-Comment'].trim() !== '') {
        pequestion2 = surveyData['pequestion2-Comment'];
    } else {
        pequestion2 = pequestion2 || "";
    }

    // Handle pequestion11 (Cooperative Name)
    if (surveyData['pequestion11-Comment'] && surveyData['pequestion11-Comment'].trim() !== '') {
        pequestion11 = surveyData['pequestion11-Comment'];
    } else {
        pequestion11 = pequestion11 || "";
    }

    // For debugging: Add console logs for each treated question
    console.log("Final pequestion1 value being sent to Android:", pequestion1);
    console.log("Final pequestion2 value being sent to Android:", pequestion2);
    console.log("Final pequestion11 value being sent to Android:", pequestion11);

    Android.insertPE(
        pequestion1, pequestion2, pequestion3 || "", pequestion4 || "", pequestion5 || "",
        pequestion6 || "", pequestion7 || "", pequestion8 || "", pequestion9 || "", pequestion10 || "",
        sanitizeInput(pequestion11), pequestion12 || "", pequestion13 || "", pequestion14 || "", farmer_photo || ""
    );
    Android.completeSurvey();
});