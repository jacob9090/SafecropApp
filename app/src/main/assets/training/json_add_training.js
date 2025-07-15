const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "text",
          "name": "training_code",
          "title": "Date",
          "inputType": "date",
          "isRequired": true
        },
        {
          "type": "dropdown",
          "name": "district",
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
          "name": "community",
          "title": "Select community",
          "isRequired": true,
          "choices": [
            "Bomaa",
            "Derma"
          ],
          "showOtherItem": true,
          "otherText": "Other (Specify)"
        },
        {
          "type": "text",
          "name": "train_question1",
          "title": "Date",
          "inputType": "date",
          "isRequired": true
        },
        {
          "type": "text",
          "name": "train_question2",
          "title": "Duration",
          "isRequired": true
        },
        {
          "type": "text",
          "name": "train_question3",
          "title": "Year of Certification",
          "inputType": "number",
          "isRequired": true
        },
        {
          "type": "text",
          "name": "train_question4",
          "title": "Number of male",
          "inputType": "number",
          "isRequired": true
        },
        {
          "type": "text",
          "name": "train_question5",
          "title": "Number of Female",
          "inputType": "number",
          "isRequired": true
        },
        {
          "type": "tagbox",
          "name": "train_question6",
          "title": "Training Topics (Checkbox of all training)",
          "choices": [
            "Item 1",
            "Item 2",
            "Item 3"
          ]
        },
        {
          "type": "text",
          "name": "train_question7",
          "title": "Name of Facilitator",
          "isRequired": true
        },
        {
          "type": "signaturepad",
          "name": "signature",
          "title": "Signature of enumerator",
          "isRequired": true
        },
       {
         "type": "panel",
         "name": "location_panel",
         "elements": [
           {
             "type": "text",
             "name": "training_location",
             "title": "Geolocation",
             "isRequired": true,
             "readOnly": true
           },
           {
             "type": "html",
             "name": "getTrainingLocation",
             "html": "<div id='location-container' style='text-align: center;'>\
             <button id='getTrainingLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button>\</div>"
           }
         ]
       },
        {
          "type": "panel",
          "name": "photo_panel",
          "title": "Thumbprint of Farmer (Picture)",
          "elements": [
            {
              "type": "html",
              "name": "training_photo",
              "html": "<div id='photo-container' style='text-align: center;'>\
                <img id='FarmerPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='Inspection Photo'/>\
                <button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button>\
              </div>"
            }
          ]
        },
        {
          "type": "panel",
          "name": "train_panel8",
          "title": "TRAINING EVALUATION",
          "elements": [
            {
              "type": "html",
              "name": "train_question8",
              "html": "<div style=\"background-color: #A52B2A; color: #FFFFFF; padding: 10px;\"><strong>Instructions:</strong> Please tick your level of agreement with the statements listed below (Strongly Agree 3, Agree 2, Disagree 1)</h5></div>"
            }
          ]
        },
        {
          "type": "slider",
          "name": "train_question9",
          "title": "The objectives of the training were met",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "train_question10",
          "title": "The presenter(s) were engaging",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "train_question11",
          "title": "The presentation materials were relevant",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "train_question12",
          "title": "The course length was appropriate",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "train_question13",
          "title": "The pace of the course was appropriate to the content and attendees",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "train_question14",
          "title": "The exercises/role play were helpful and relevant",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "train_question15",
          "title": "The venue was appropriate for the event",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "text",
          "name": "train_question16",
          "title": "Other comments"
        }
      ]
    }
  ]
}
