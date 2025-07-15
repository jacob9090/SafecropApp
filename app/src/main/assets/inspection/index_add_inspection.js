const survey = new Survey.Model(json);

survey.completeText = "Save Inspection";
survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateInspectionLocation(location) {
    survey.setValue('inspection_location', location);
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

// Match keys exactly with Java: (farmer_id, farmer_name, etc)
function populateSurveyFields(district, community, farmer_id, farmer_name, ghana_card, farmer_yob, phone_number, gender, inspection_date, inspector_name) {
    survey.setValue('district', district);
    survey.setValue('community', community);
    survey.setValue('farmer_id', farmer_id);
    survey.setValue('farmer_name', farmer_name);
    survey.setValue('ghana_card', ghana_card);
    survey.setValue('farmer_yob', farmer_yob);
    survey.setValue('phone_number', phone_number);
    survey.setValue('gender', gender);
    survey.setValue('inspection_date', inspection_date);
    survey.setValue('inspector_name', inspector_name);
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

function saveInspection(isDraft) {
    const data = survey.data;
    const is_sync = "0";
    Android.insertOrUpdateInspection(
        data.district || "",
        data.community || "",
        data.farmer_id || "",
        data.farmer_name || "",
        data.ghana_card || "",
        data.farmer_yob || "",
        data.phone_number || "",
        data.gender || "",
        data.inspection_date || "",
        data.inspector_name || "",
        data.inspection_question1 || "",
        data.inspection_question2 || "",
        data.inspection_question3 || "",
        data.inspection_question4 || "",
        data.inspection_question5 || "",
        data.inspection_question6 || "",
        data.inspection_question7 || "",
        data.inspection_question8 || "",
        data.inspection_question9 || "",
        data.inspection_question10 || "",
        data.inspection_question11 || "",
        data.inspection_question12 || "",
        data.inspection_question13 || "",
        data.inspection_question14 || "",
        data.inspection_question15 || "",
        data.inspection_question16 || "",
        data.inspection_question17 || "",
        data.inspection_question18 || "",
        data.inspection_question19 || "",
        data.inspection_question20 || "",
        data.inspection_question21 || "",
        data.inspection_question22 || "",
        data.inspection_question23 || "",
        data.inspection_question24 || "",
        data.inspection_question25 || "",
        data.inspection_question26 || "",
        data.inspection_question27 || "",
        data.inspection_question28 || "",
        data.inspection_question29 || "",
        data.inspection_question30 || "",
        data.inspection_question31 || "",
        data.inspection_question32 || "",
        data.inspection_question33 || "",
        data.inspection_question34 || "",
        data.inspection_question35 || "",
        data.inspection_question36 || "",
        data.inspection_question37 || "",
        data.inspection_question38 || "",
        data.inspection_question39 || "",
        data.inspection_question40 || "",
        data.inspection_question41 || "",
        data.inspection_question42 || "",
        data.inspection_question43 || "",
        data.inspection_question44 || "",
        data.inspection_question45 || "",
        data.inspection_question46 || "",
        data.inspection_question47 || "",
        data.inspection_question48 || "",
        data.inspection_question49 || "",
        data.inspection_question50 || "",
        data.inspection_question51 || "",
        data.inspection_question52 || "",
        data.inspection_question53 || "",
        data.inspection_question54 || "",
        data.inspection_question55 || "",
        data.inspection_question56 || "",
        data.inspection_question57 || "",
        data.inspection_question58 || "",
        data.inspection_question59 || "",
        data.inspection_question60 || "",
        data.inspection_question61 || "",
        data.inspection_question62 || "",
        data.inspection_question63 || "",
        data.inspection_location || "",
        data.farmer_photo || "",
        data.signature ? data.signature : null,
        is_sync,
        isDraft ? "1" : "0"
    );
    if (!isDraft) {
        Android.completeSurvey();
    }
}

// Only trigger on explicit user actions:
// - For final save: via SurveyJS completion event
survey.onComplete.add(function (survey, options) {
    saveInspection(false);
});