const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
         {
           "type": "text",
           "name": "obs_name",
           "title": "Farmer ID",
           "readOnly": true
         },
         {
           "type": "text",
           "name": "obs_district",
           "title": "District",
           "readOnly": true
         },
         {
           "type": "text",
           "name": "obs_community",
           "title": "Community",
           "readOnly": true
         },
         {
           "type": "dropdown",
           "name": "obsquestion6",
           "title": "Gender of child",
           "isRequired": true,
           "choices": [
             "Male",
             "Female"
           ]
         },
        {
          "type": "text",
          "name": "obsquestion7",
          "title": "Please indicate if the child is the first-born, second-born, etc.\n",
          "maxLength": 15
        },
        {
          "type": "dropdown",
          "name": "obsquestion8",
          "title": "Is this the first or second follow-up interview conducted for this child?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "obsquestion9",
          "title": "Does this follow-up interview concern a child worker or a child at risk?\n",
          "maxLength": 50
        },
        {
          "type": "text",
          "name": "obsquestion10",
          "title": "Date of discovery on the farm or in household interview\n",
          "inputType": "date"
        },
        {
          "type": "text",
          "name": "obsquestion11",
          "title": "Date of birth of child\n",
          "inputType": "date"
        },
        {
          "type": "dropdown",
          "name": "obsquestion12",
          "title": "With whom does the child currently live?\n",
          "choices": [
            "Father",
            "Mother",
            "Grandparents",
            "Other Relatives"
          ]
        },
        {
          "type": "dropdown",
          "name": "obsquestion13",
          "title": "Who takes care of the child?\n",
          "choices": [
            "Both Parents",
            "Father",
            "Mother",
            "Grand Parents",
            "Other Relatives"
          ]
        },
        {
          "type": "dropdown",
          "name": "obsquestion14",
          "title": "If the child is between 5 and 17 years old, does he/she go to school?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "obsquestion15",
          "title": "What are the problems the child faces in school\n",
          "maxLength": 100
        },
        {
          "type": "text",
          "name": "obsquestion16",
          "title": "What are the problems the child faces out of school?\n",
          "maxLength": 100
        },
        {
          "type": "dropdown",
          "name": "obsquestion17",
          "title": "Has the child worked within the last 12 months?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "obsquestion18",
          "title": "Direct actions aimed at improving the child's situation\n",
          "maxLength": 100
        },
        {
          "type": "text",
          "name": "obsquestion19",
          "title": "Indirect actions aimed at improving the child's situation\n",
          "maxLength": 100
        },
        {
          "type": "dropdown",
          "name": "obsquestion20",
          "title": "Do you confirm that the child is no longer in child labor?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "obsquestion21",
          "title": "Is a follow-up interview required?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "panel",
          "name": "location_panel",
          "elements": [
            {
              "type": "text",
              "name": "obs_location",
              "title": "Geo - Location",
              "readOnly": true
            },
            {
              "type": "html",
              "name": "getComLocation",
              "html": "<div id='location-container' style='text-align: center;'>\
              <button id='getComLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button>\</div>"
            }
          ]
        },
        {
          "type": "panel",
          "name": "photo_panel",
          "title": "Photo of community\n",
          "elements": [
            {
              "type": "html",
              "name": "obs_photo",
              "html": "<div id='photo-container' style='text-align: center;'>\
                <img id='FarmerPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='Farmer Photo'/>\
                <button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button>\
              </div>"
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
  ]
}






//const json = {
//  "logoPosition": "right",
//  "pages": [
//    {
//      "name": "page1",
//      "elements": [
//      {
//        "type": "text",
//        "name": "obs_name",
//        "title": "Name of School",
//        "maxLength": 50
//      },
//        {
//          "type": "dropdown",
//          "name": "obs_district",
//          "title": "Name of district.",
//          "choices": [
//            "District1",
//            "District2"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "obs_community",
//          "title": " Select community",
//          "choices": [
//            "Community1",
//            "Community2"
//          ]
//        },
//        {
//          "type": "panel",
//          "name": "location_panel",
//          "elements": [
//            {
//              "type": "text",
//              "name": "obs_location",
//              "title": "Geo - Location",
//              "readOnly": true
//            },
//            {
//              "type": "html",
//              "name": "getComLocation",
//              "html": "<div id='location-container' style='text-align: center;'>\
//              <button id='getComLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button>\</div>"
//            }
//          ]
//        },
//        {
//          "type": "panel",
//          "name": "photo_panel",
//          "title": "Photo of community\n",
//          "elements": [
//            {
//              "type": "html",
//              "name": "obs_photo",
//              "html": "<div id='photo-container' style='text-align: center;'>\
//                <img id='FarmerPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='Farmer Photo'/>\
//                <button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button>\
//              </div>"
//            }
//          ]
//        },
//        {
//          "type": "signaturepad",
//          "name": "signature",
//          "title": "Signature of field agent",
//          "isRequired": true
//        }
//      ]
//    }
//  ]
//}