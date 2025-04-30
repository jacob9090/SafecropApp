const survey = new Survey.Model(json);

survey.completeText = "Save Assessment";
survey.showCompletedPage = false;

function handleGetLocation() {
    Android.openLocationActivity();
}

function updateChildLocation(location) {
    survey.data.child_location = location;
    survey.setValue('child_location', location);
}

function populateSurveyFields(farmerId, farmerDistrict, farmerVillage) {
    survey.setValue('farmer_id', farmerId);
    survey.setValue('farmer_district', farmerDistrict);
    survey.setValue('farmer_village', farmerVillage);
}

function sanitizeInput(value) {
    if (Array.isArray(value)) {
        return value.join(",");
    }
    return value || ""; // Return value if it's a string, else return an empty string
}

survey.onComplete.add(function (survey, options) {
    const surveyData = survey.data;
    const { farmer_id, farmer_district, farmer_village,
    childquestion4, child1question1, child1question2, child1question3, child1question4, child1question5,
    child1question6, child1question7, child1question8, child1question9, child1question10, child1question11,
    child1question12, child1question13, child1question14, child1question15, child1question16, child1question17,
    child1question18, child1question19, child2question1, child2question2, child2question3, child2question4,
    child2question5, child2question6, child2question7, child2question8, child2question9, child2question10,
    child2question11, child2question12, child2question13, child2question14, child2question15, child2question16,
    child2question17, child2question18, child2question19, child3question1, child3question2, child3question3,
    child3question4, child3question5, child3question6, child3question7, child3question8, child3question9,
    child3question10, child3question11, child3question12, child3question13, child3question14, child3question15,
    child3question16, child3question17, child3question18, child3question19, child4question1, child4question2,
    child4question3, child4question4, child4question5, child4question6, child4question7, child4question8,
    child4question9, child4question10, child4question11, child4question12, child4question13, child4question14,
    child4question15, child4question16, child4question17, child4question18, child4question19, child5question1,
    child5question2, child5question3, child5question4, child5question5, child5question6, child5question7,
    child5question8, child5question9, child5question10, child5question11, child5question12, child5question13,
    child5question14, child5question15, child5question16, child5question17, child5question18, child5question19,
    child6question1, child6question2, child6question3, child6question4, child6question5, child6question6,
    child6question7, child6question8, child6question9, child6question10, child6question11, child6question12,
    child6question13, child6question14, child6question15, child6question16, child6question17, child6question18,
    child6question19, child7question1, child7question2, child7question3, child7question4, child7question5,
    child7question6, child7question7, child7question8, child7question9, child7question10, child7question11,
    child7question12, child7question13, child7question14, child7question15, child7question16, child7question17,
    child7question18, child7question19, child8question1, child8question2, child8question3, child8question4,
    child8question5, child8question6, child8question7, child8question8, child8question9, child8question10,
    child8question11, child8question12, child8question13, child8question14, child8question15, child8question16,
    child8question17, child8question18, child8question19, child9question1, child9question2, child9question3,
    child9question4, child9question5, child9question6, child9question7, child9question8, child9question9,
    child9question10, child9question11, child9question12, child9question13, child9question14, child9question15,
    child9question16, child9question17, child9question18, child9question19, child10question1, child10question2,
    child10question3, child10question4, child10question5, child10question6, child10question7, child10question8,
    child10question9, child10question10, child10question11, child10question12, child10question13, child10question14,
    child10question15, child10question16, child10question17, child10question18, child10question19, childquestion5,
    child_location, signature } = surveyData;

    // Send the data including the raw PNG data for the signature
    Android.insertSurveyData(
    farmer_id || "", farmer_district || "", farmer_village || "", childquestion4 || "",
    child1question1 || "", child1question2 || "", child1question3 || "", child1question4 || "", child1question5 || "",
    child1question6 || "", child1question7 || "", child1question8 || "", child1question9 || "", child1question10 || "",
    child1question11 || "", child1question12 || "", sanitizeInput(child1question13), child1question14 || "", child1question15 || "",
    child1question16 || "", child1question17 || "", child1question18 || "", child1question19 || "", child2question1 || "",
    child2question2 || "", child2question3 || "", child2question4 || "", child2question5 || "", child2question6 || "",
    child2question7 || "", child2question8 || "", child2question9 || "", child2question10 || "", child2question11 || "",
    child2question12 || "", sanitizeInput(child2question13), child2question14 || "", child2question15 || "", child2question16 || "",
    child2question17 || "", child2question18 || "", child2question19 || "", child3question1 || "", child3question2 || "",
    child3question3 || "", child3question4 || "", child3question5 || "", child3question6 || "", child3question7 || "",
    child3question8 || "", child3question9 || "", child3question10 || "", child3question11 || "", child3question12 || "",
    sanitizeInput(child3question13), child3question14 || "", child3question15 || "", child3question16 || "", child3question17 || "",
    child3question18 || "", child3question19 || "", child4question1 || "", child4question2 || "", child4question3 || "",
    child4question4 || "", child4question5 || "", child4question6 || "", child4question7 || "", child4question8 || "",
    child4question9 || "", child4question10 || "", child4question11 || "", child4question12 || "", sanitizeInput(child4question13),
    child4question14 || "", child4question15 || "", child4question16 || "", child4question17 || "", child4question18 || "",
    child4question19 || "", child5question1 || "", child5question2 || "", child5question3 || "", child5question4 || "",
    child5question5 || "", child5question6 || "", child5question7 || "", child5question8 || "", child5question9 || "",
    child5question10 || "", child5question11 || "", child5question12 || "", sanitizeInput(child5question13), child5question14 || "",
    child5question15 || "", child5question16 || "", child5question17 || "", child5question18 || "", child5question19 || "",
    child6question1 || "", child6question2 || "", child6question3 || "", child6question4 || "", child6question5 || "",
    child6question6 || "", child6question7 || "", child6question8 || "", child6question9 || "", child6question10 || "",
    child6question11 || "", child6question12 || "", sanitizeInput(child6question13), child6question14 || "", child6question15 || "",
    child6question16 || "", child6question17 || "", child6question18 || "", child6question19 || "", child7question1 || "",
    child7question2 || "", child7question3 || "", child7question4 || "", child7question5 || "", child7question6 || "",
    child7question7 || "", child7question8 || "", child7question9 || "", child7question10 || "", child7question11 || "",
    child7question12 || "", sanitizeInput(child7question13), child7question14 || "", child7question15 || "", child7question16 || "",
    child7question17 || "", child7question18 || "", child7question19 || "", child8question1 || "", child8question2 || "",
    child8question3 || "", child8question4 || "", child8question5 || "", child8question6 || "", child8question7 || "",
    child8question8 || "", child8question9 || "", child8question10 || "", child8question11 || "", child8question12 || "",
    sanitizeInput(child8question13), child8question14 || "", child8question15 || "", child8question16 || "", child8question17 || "",
    child8question18 || "", child8question19 || "", child9question1 || "", child9question2 || "", child9question3 || "",
    child9question4 || "", child9question5 || "", child9question6 || "", child9question7 || "", child9question8 || "",
    child9question9 || "", child9question10 || "", child9question11 || "", child9question12 || "", sanitizeInput(child9question13),
    child9question14 || "", child9question15 || "", child9question16 || "", child9question17 || "", child9question18 || "",
    child9question19 || "", child10question1 || "", child10question2 || "", child10question3 || "", child10question4 || "",
    child10question5 || "", child10question6 || "", child10question7 || "", child10question8 || "", child10question9 || "",
    child10question10 || "", child10question11 || "", child10question12 || "", sanitizeInput(child10question13), child10question14 || "",
    child10question15 || "", child10question16 || "", child10question17 || "", child10question18 || "", child10question19 || "", childquestion5 || "",
    child_location || "", signature || ""
    );
    Android.completeSurvey();
});

// Render the survey
$("#surveyElement").Survey({ model: survey });
