const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "dropdown",
          "name": "gmrquestion1",
          "title": "Select district",
          "isRequired": true,
          "choices": [
            "Tepa",
            "Bechem"
          ],
          "otherText": "Other (Specify)"
        },
        {
          "type": "dropdown",
          "name": "gmrquestion2",
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
          "otherText": "Other (Specify)"
        },
        {
          "type": "dropdown",
          "name": "gmrquestion3",
          "title": "Which cooperative do you belong in",
          "choices": [
            "Anidaso Cooperative",
            "Anidaso Mmaa",
            "After Two"
          ]
        },
        {
          "type": "dropdown",
          "name": "gmrquestion4",
          "title": "Varieties of cocoa",
          "choices": [
            "Hybrid",
            "Amazonia",
            "Mixed"
          ]
        },
        {
          "type": "text",
          "name": "gmrquestion5",
          "title": "Farmer code",
          "isRequired": true
        },
        {
          "type": "text",
          "name": "gmrquestion6",
          "title": "Farmer name",
          "isRequired": true
        },
        {
          "type": "dropdown",
          "name": "gmrquestion7",
          "title": "Do you have a valid identification card",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "gmrquestion8",
          "visibleIf": "{gmrquestion7} = 'Yes'",
          "title": "Identification card type",
          "choices": [
            "Ghana card",
            "Cocoboad card"
          ],
          "showOtherItem": true
        },
        {
          "type": "text",
          "name": "gmrquestion9",
          "visibleIf": "{gmrquestion7} = 'Yes'",
          "title": "ID Number"
        },
        {
          "type": "panel",
          "name": "photo_panel",
          "visibleIf": "{gmrquestion7} = 'Yes'",
          "title": "10. Photo of ID card\n",
          "elements": [
            {
              "type": "html",
              "name": "gmrquestion10",
              "html": "<div id='photo-container' style='text-align: center;'>\
                <img id='photoIdDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='ID Card Photo'/>\
                <button id='getIdPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetIdPhoto()'>Get Photo</button>\
              </div>"
            }
          ]
        },
        {
          "type": "dropdown",
          "name": "gmrquestion11",
          "title": "Gender",
          "choices": [
            "Male",
            "Female"
          ]
        },
        {
          "type": "text",
          "name": "gmrquestion12",
          "title": "Date of birth",
          "inputType": "date",
          "min": "1900-01-01",
          "max": "2006-01-01"
        },
        {
          "type": "dropdown",
          "name": "gmrquestion13",
          "title": "Do you have a registered SIM card",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "gmrquestion14",
          "visibleIf": "{gmrquestion13} = 'Yes'",
          "title": "SIM Number"
        },
        {
          "type": "dropdown",
          "name": "gmrquestion15",
          "title": "Do you have a registered mobile money number",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "gmrquestion16",
          "visibleIf": "{gmrquestion15} = 'Yes'",
          "title": "MoMo number"
        },
        {
          "type": "dropdown",
          "name": "gmrquestion17",
          "title": "What is your level of education?",
          "choices": [
            "Kindergarten",
            "Primary school",
            "JHS",
            "Technical / Vocational training",
            "Tertiary",
            "None"
          ]
        },
        {
          "type": "text",
          "name": "gmrquestion18",
          "title": "Total number of members living in the household?",
          "inputType": "number"
        },
        {
          "type": "dropdown",
          "name": "gmrquestion19",
          "title": "How many children aged 0 to 17 currently live in your household?",
          "choices": [
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10"
          ],
          "showNoneItem": true
        },
        {
          "type": "text",
          "name": "gmrquestion20",
          "visibleIf": "{gmrquestion19} anyof [2, 1, 3, 4, 5, 6, 7, 8, 9, 10]",
          "title": "How many of the children mentioned above are of school-going age (5 to 17 years)?"
        },
        {
          "type": "text",
          "name": "gmrquestion21",
          "visibleIf": "{gmrquestion19} anyof [1, 2, 3, 4, 5, 6, 8, 7, 9, 10]",
          "title": "How many of the school-going children (aged 5 to 17) are currently enrolled in school?",
          "inputType": "number"
        },
        {
          "type": "panel",
          "name": "genderdistributionpanel",
          "visibleIf": "{gmrquestion19} anyof [1, 3, 2, 4, 5, 6, 7, 8, 9, 10]",
          "title": "What is the gender distribution of the children in the household? Please specify the number of boys and girls. (0 - 17)",
          "elements": [
            {
              "type": "text",
              "name": "gmrquestion22",
              "title": "Male",
              "inputType": "number"
            },
            {
              "type": "text",
              "name": "gmrquestion23",
              "title": "Female",
              "inputType": "number"
            }
          ]
        },
        {
          "type": "text",
          "name": "gmrquestion24",
          "title": "How many cocoa plots do you have?\n",
          "inputType": "number"
        },
        {
          "type": "dropdown",
          "name": "gmrquestion25",
          "title": "Do you have any other plots?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "gmrquestion26",
          "visibleIf": "{gmrquestion25} = 'Yes'",
          "title": "How many plots do you have?\n",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "gmrquestion27",
          "visibleIf": "{gmrquestion25} = 'Yes'",
          "title": "What are the acreages of your plots?\r\n"
        },
        {
          "type": "dropdown",
          "name": "gmrquestion28",
          "visibleIf": "{gmrquestion25} = 'Yes'",
          "title": "What type of crop do you grow on the plots?\n",
          "choices": [
            "Vegetables",
            "Food crop",
            "Cash crop"
          ]
        },
        {
          "type": "dropdown",
          "name": "gmrquestion29",
          "title": "Do you apply pesticides?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "gmrquestion30",
          "visibleIf": "{gmrquestion29} = 'Yes'",
          "title": "How many times do you apply it in a season?\r\n",
          "choices": [
            "Once a year",
            "2-4 times a year",
            "More than 4 times a year"
          ]
        },
        {
          "type": "dropdown",
          "name": "gmrquestion31",
          "title": "Do you apply fungicides?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "gmrquestion32",
          "visibleIf": "{gmrquestion31} = 'Yes'",
          "title": "How many times do you apply it in a season?\r\n",
          "choices": [
            "Once a year",
            "2-4 times a year",
            "More than 4 times a year"
          ]
        },
        {
          "type": "dropdown",
          "name": "gmrquestion33",
          "title": "Do you use organic fertilizer?\r\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "gmrquestion34",
          "visibleIf": "{gmrquestion33} = 'Yes'",
          "title": "What type of organic fertilizer do you use?\r\n",
          "choices": [
            "Poultry manure",
            "Compost",
            "Disease-free farm debris",
            "Farmyard manure"
          ]
        },
        {
          "type": "dropdown",
          "name": "gmrquestion35",
          "visibleIf": "{gmrquestion33} = 'Yes'",
          "title": "How many times do you apply it in a season?\r\n",
          "choices": [
            "Once a year",
            "2-4 times a year",
            "More than 4 times a year"
          ]
        },
        {
          "type": "text",
          "name": "gmrquestion36",
          "title": "How many bags of cocoa did you produce/harvest last season 23/24?\r\n"
        },
        {
          "type": "text",
          "name": "gmrquestion37",
          "title": "How many bags of cocoa do you estimate to produce this season 24/25?\r\n"
        },
        {
          "type": "dropdown",
          "name": "gmrquestion38",
          "title": "Is your farm located near a high conservation area (forest)\r\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "gmrquestion39",
          "title": "Do you agree to work with safe crop Agricultural services and will abide by all internal rules and standards the group\r\n",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "panel",
          "name": "photo_panel",
          "title": "Photo of farmer\n",
          "elements": [
            {
              "type": "html",
              "name": "gmrquestion40",
              "html": "<div id='photo-container' style='text-align: center;'>\
                <img id='photoFarmerDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='School Photo'/>\
                <button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button>\
              </div>"
            }
          ]
        },
        {
          "type": "panel",
          "name": "photo_panel",
          "title": "Signature/Thumbprint of farmer\n",
          "elements": [
            {
              "type": "html",
              "name": "gmrquestion41",
              "html": "<div id='photo-container' style='text-align: center;'>\
                <img id='photoTpDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='School Photo'/>\
                <button id='getTpPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetTpPhoto()'>Get Photo</button>\
              </div>"
            }
          ]
        },
        {
          "type": "signaturepad",
          "name": "gmrquestion42",
          "title": "Agent Signature",
          "isRequired": true,
          "signatureWidth": 600
        },
        {
          "type": "panel",
          "name": "location_panel",
          "elements": [
            {
              "type": "text",
              "name": "gmrquestion43",
              "title": "Geo-Location",
              "readOnly": true
            },
            {
              "type": "html",
              "name": "getGMRLocation",
              "html": "<div style=\"text-align: center;\"><button id=\"getGMRLocation\" style=\"width: 100%; background-color: brown; color: white; display: block;\" type=\"button\" onclick=\"handleGetGMRLocation()\">Get Location</button></div>"
            }
          ]
        }
      ]
    }
  ]
}
