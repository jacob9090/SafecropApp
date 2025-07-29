const json = {
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "dropdown",
          "name": "craquestion1",
          "title": "Select district",
          "isRequired": true,
          "choices": [
            "Bechem",
            "Tepa"
          ],
          "placeholder": "Select district"
        },
        {
          "type": "dropdown",
          "name": "craquestion2",
          "title": "Select community",
          "isRequired": true,
          "choices": [
            "Abechem",
            "Apesika",
            "Appiahkrom",
            "Asenchem",
            "Bomaa",
            "Brosankro",
            "Derma",
            "Derma Nkwankyire",
            "Dumakwai",
            "Dwomo",
            "Jacobu",
            "Katapei",
            "Kisuogya",
            "Kramokrom",
            "Kruboa",
            "Kusuogya",
            "Kwaku Dua krom",
            "Kyekyewere",
            "Mampong",
            "Old Town",
            "Pokuakura",
            "Submpang",
            "Subompan",
            "Subompang",
            "Subonpang",
            "Tanokrom",
            "Techimantia",
            "Tepa"
          ],
          "placeholder": "Select community"
        },
        {
          "type": "dropdown",
          "name": "craquestion3",
          "title": "Is the public school in your community signed on to the school feeding programme?",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "craquestion4",
          "title": "Are there days in the week when pupils are not served with food when they go to school (if the school is on the school feeding programme)?",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "craquestion5",
          "title": "Do schools ask parents to pay fees to cover uniforms, books or other school materials?",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "craquestion6",
          "title": "Is the public primary and junior high school more than 4km away (so too far away to walk or cycle to safely)?",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "craquestion7",
          "title": "Do public primary and junior high schools use corporal punishment to discipline school pupils?",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "craquestion8",
          "title": "Does the community have difficulty accessing the local road network regularly, throughout the year?",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "craquestion9",
          "title": "Does the community have difficulty accessing the mobile phone network?",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "craquestion10",
          "title": "Are there temporary or seasonal workers from other parts of Ghana or other countries who seek work in the community?",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "craquestion11",
          "title": "Are women in this community engaged in other livelihood activities, in addition to cocoa farming or mining?",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "craquestion12",
          "title": "Are women in this community considered for or involved in leadership roles?",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "craquestion13",
          "title": "Are most women in this community not able to read and write?",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "panel",
          "name": "location_panel",
          "elements": [
          {
            "type": "text",
            "name": "cra_location",
            "title": "Geo - Location",
            "readOnly": true
          },
          {
            "type": "html",
            "name": "getCraLocation",
            "html": "<div id='location-container' style='text-align: center;'>\
            <button id='getCraLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button>\</div>"
          }
        ]
        },
        {
          "type": "signaturepad",
          "name": "signature",
          "title": "Signature of field agent",
          "isRequired": true,
          "signatureWidth": 600
        }
      ]
    }
  ],
  "showPageTitles": false,
  "showCompletedPage": false,
  "clearInvisibleValues": "onHiddenContainer",
  "completeText": "Save Survey"
}