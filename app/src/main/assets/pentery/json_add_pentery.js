const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "dropdown",
          "name": "pequestion1",
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
          "name": "pequestion2",
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
          "name": "pequestion3",
          "title": "Farmer Name (As On Ghana Card)",
          "isRequired": true
        },
        {
          "type": "text",
          "name": "pequestion4",
          "title": "No. Of Plots",
          "inputType": "number",
          "min": 1,
          "max": 20
        },
        {
          "type": "text",
          "name": "pequestion5",
          "title": "Gh. Card No."
        },
        {
          "type": "text",
          "name": "pequestion6",
          "title": "Cocobod card ID"
        },
        {
          "type": "dropdown",
          "name": "pequestion7",
          "title": "Gender",
          "isRequired": true,
          "choices": [
            "Male",
            "Female"
          ]
        },
        {
          "type": "text",
          "name": "pequestion8",
          "title": "Year of Birth",
          "isRequired": true,
          "validators": [
            {
              "type": "numeric",
              "text": "Please enter a valid year between 1900 and 2024.",
              "minValue": 1900,
              "maxValue": 2010
            },
            {
              "type": "regex",
              "text": "Please enter a 4-digit year.",
              "regex": "^\\d{4}$"
            }
          ],
          "inputType": "number",
          "min": 1900,
          "max": 2010,
          "placeholder": "YYYY"
        },
        {
          "type": "text",
          "name": "pequestion9",
          "title": "Tel. Number",
          "inputType": "tel"
        },
        {
          "type": "text",
          "name": "pequestion10",
          "title": "Caretaker (If Any)"
        },
        {
          "type": "dropdown",
          "name": "pequestion11",
          "title": "Cooperative Name",
          "choices": [
            "Anidaso Cooperative",
            "Anidaso Mmaa",
            "After Two"
          ],
          "showOtherItem": true,
          "otherText": "Other (Cooperative)"
        },
        {
          "type": "dropdown",
          "name": "pequestion12",
          "title": "Interested In VSLA?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "pequestion13",
          "title": "Name Of Field Agent"
        },
        {
          "type": "panel",
          "name": "photo_panel",
          "title": "Photo of farmer",
          "elements": [
            {
              "type": "html",
              "name": "pe_photo",
              "html": "<div id='photo-container' style='text-align: center;'>\
                <img id='FarmerPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='Farmer Photo'/>\
                <button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button>\
              </div>"
            }
          ]
        }
      ]
    }
  ]
}