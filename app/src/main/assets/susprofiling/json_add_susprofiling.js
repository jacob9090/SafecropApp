const json = {
   "logoPosition": "right",
   "pages": [
     {
       "name": "page1",
       "elements": [
         {
           "type": "text",
           "name": "farmer_id",
           "title": "Farm Code",
           "isRequired": true
         },
         {
           "type": "text",
           "name": "farmer_name",
           "title": "Farmer's Name",
           "isRequired": true
         },
         {
           "type": "dropdown",
           "name": "farmer_gender",
           "title": "Gender",
           "isRequired": true,
           "choices": [
             "Male",
             "Female"
           ]
         },
         {
           "type": "dropdown",
           "name": "district",
           "title": "Select district",
           "isRequired": true,
           "choices": [
             "Assin Fosu",
             "Bechem",
             'Goaso',
             "Tepa"
           ],
           "showOtherItem": true,
           "otherText": "Other (District)"
         },
         {
           "type": "dropdown",
           "name": "community",
           "title": "Select community",
           "isRequired": true,
           "choices": [
             "Bomaa",
             "Derma",
             "Dumakwai",
             "Subompan",
             "Techimantia"
           ],
           "showOtherItem": true,
           "otherText": "Other (Community)"
         },
         {
           "type": "text",
           "name": "farmer_dob",
           "title": "Date of Birth",
           "inputType": "date"
         },
         {
           "type": "text",
           "name": "ghana_card",
           "title": "National Identification Number (Ghana Card No.)",
           "inputType": "number"
         },

         {
           "type": "text",
           "name": "suspro_question1",
           "title": "Farm Size (In Hectares)",
           "inputType": "number"
         },
         {
           "type": "text",
           "name": "suspro_question2",
           "title": "Year of Establishment",
           "inputType": "number"
         },
         {
           "type": "text",
           "name": "suspro_question3",
           "title": "Number of Cocoa Trees",
           "inputType": "number"
         },
         {
           "type": "text",
           "name": "suspro_question4",
           "title": "Other Crops Grown"
         },
         {
           "type": "dropdown",
           "name": "suspro_question5",
           "title": "Is the Farm under Agroforestry?",
           "choices": [
             "Item 1",
             "Item 2"
           ]
         },
         {
           "type": "dropdown",
           "name": "suspro_question6",
           "title": "Land Ownership",
           "choices": [
             "Owned",
             "Leased",
             "Family Land",
             "Others"
           ]
         },
         {
           "type": "text",
           "name": "suspro_question7",
           "visibleIf": "{question12} = 'Others'",
           "title": "If  others please specify"
         },
         {
           "type": "text",
           "name": "suspro_question8",
           "visibleIf": "{question12} = 'Leased'",
           "title": "If leased, Duration of lease",
           "inputType": "number"
         },
         {
           "type": "dropdown",
           "name": "suspro_question9",
           "title": "Do you have Land Title Document Available",
           "choices": [
             "Yes",
             "No"
           ]
         },
         {
           "type": "dropdown",
           "name": "suspro_question10",
           "title": "Is this farm currently certified organic?",
           "choices": [
             "Yes",
             "No"
           ]
         },
         {
           "type": "dropdown",
           "name": "suspro_question11",
           "title": "If no, is the farm in the conversion period?",
           "choices": [
             "Yes",
             "No"
           ]
         },
         {
           "type": "text",
           "name": "suspro_question12",
           "title": "When did you start organic farming?",
           "inputType": "date"
         },
         {
           "type": "dropdown",
           "name": "suspro_question13",
           "title": "Have you been using synthetic inputs in the last 3 years?",
           "choices": [
             "Yes",
             "No"
           ]
         },
         {
           "type": "text",
           "name": "suspro_question14",
           "visibleIf": "{question18} = 'Yes'",
           "title": "If yes, give examples of Active Ingredients"
         },
         {
           "type": "tagbox",
           "name": "suspro_question15",
           "title": "Fertilizer Used (check all that apply)",
           "choices": [
             "Compost",
             "Manure",
             "Cover Crops",
             "None",
             "Other"
           ]
         },
         {
           "type": "tagbox",
           "name": "suspro_question16",
           "title": "Pest Control Methods (check all that apply)\n",
           "choices": [
             "Neem Oil",
             "Biological Control",
             "Manual Weeding",
             "Other"
           ]
         },
         {
           "type": "tagbox",
           "name": "suspro_question17",
           "title": "Weed Management",
           "choices": [
             "Hoe Weeding",
             "Mulching",
             "Machete",
             "Other"
           ]
         },
         {
           "type": "dropdown",
           "name": "suspro_question18",
           "title": "Have you received training on organic farming practices?",
           "choices": [
             "Yes",
             "No"
           ]
         },
         {
           "type": "text",
           "name": "suspro_question19",
           "visibleIf": "{question24} = 'Yes'",
           "title": "If yes, specify when and by whom"
         },
         {
           "type": "dropdown",
           "name": "suspro_question20",
           "title": "Do you have access to technical support?",
           "choices": [
             "Yes",
             "No"
           ]
         },
         {
           "type": "text",
           "name": "suspro_question21",
           "visibleIf": "{question26} = 'Yes'",
           "title": "If yes, specify when and by whom"
         },
         {
           "type": "dropdown",
           "name": "suspro_question22",
           "title": "Are you willing to comply with RA certification standards?",
           "choices": [
             "Yes",
             "No"
           ]
         },
         {
           "type": "dropdown",
           "name": "suspro_question23",
           "title": "Are you willing to undergo regular inspections?",
           "choices": [
             "Yes",
             "No"
           ]
         },
         {
           "type": "dropdown",
           "name": "suspro_question24",
           "title": "Do you agree to maintain records of farm activities?",
           "choices": [
             "Yes",
             "No"
           ]
         },
         {
           "type": "text",
           "name": "suspro_question25",
           "title": "I ......., declare that the information provided in this form is accurate to the best of my knowledge.\n2. I commit to following organic farming practices and agree to be part of the internal control system (ICS) for RA certification."
         },
         {
           "type": "signaturepad",
           "name": "signature",
           "title": "Farmer's Signature"
         }
       ]
     }
   ]
 }
