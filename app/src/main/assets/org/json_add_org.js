const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "text",
          "name": "orgquestion0",
          "title": "Farmer's Name\n"
        },
        {
          "type": "dropdown",
          "name": "orgquestion1",
          "title": "Gender",
          "choices": [
            "Male",
            "Female"
          ]
        },
        {
          "type": "text",
          "name": "orgquestion2",
          "title": "Date of Birth",
          "inputType": "date"
        },
        {
          "type": "dropdown",
          "name": "orgquestion3",
          "title": "Name of Community",
          "choices": [
            "Community1",
            "Community2",
            "Community3"
          ]
        },
        {
          "type": "dropdown",
          "name": "orgquestion4",
          "title": "District",
          "choices": [
            "District1",
            "District2",
            "District3"
          ]
        },
        {
          "type": "text",
          "name": "orgquestion5",
          "title": "National Identification Number (Ghana Card No.)",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "orgquestion6",
          "title": "Farm Code "
        },
        {
          "type": "text",
          "name": "orgquestion7",
          "title": "Farm Size (In Hectares)",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "orgquestion8",
          "title": "Year of Establishment",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "orgquestion9",
          "title": "Number of Cocoa Trees",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "orgquestion10",
          "title": "Other Crops Grown"
        },
        {
          "type": "dropdown",
          "name": "orgquestion11",
          "title": "Is the Farm under Agroforestry?",
          "choices": [
            "Item 1",
            "Item 2"
          ]
        },
        {
          "type": "dropdown",
          "name": "orgquestion12",
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
          "name": "orgquestion13",
          "visibleIf": "{question12} = 'Others'",
          "title": "If  others please specify"
        },
        {
          "type": "text",
          "name": "orgquestion14",
          "visibleIf": "{question12} = 'Leased'",
          "title": "If leased, Duration of lease",
          "inputType": "number"
        },
        {
          "type": "dropdown",
          "name": "orgquestion15",
          "title": "Do you have Land Title Document Available",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "orgquestion16",
          "title": "Is this farm currently certified organic?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "orgquestion17",
          "title": "If no, is the farm in the conversion period?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "orgquestion19",
          "title": "When did you start organic farming?",
          "inputType": "date"
        },
        {
          "type": "dropdown",
          "name": "orgquestion18",
          "title": "Have you been using synthetic inputs in the last 3 years?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "orgquestion20",
          "visibleIf": "{question18} = 'Yes'",
          "title": "If yes, give examples of Active Ingredients"
        },
        {
          "type": "tagbox",
          "name": "orgquestion21",
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
          "name": "orgquestion22",
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
          "name": "orgquestion23",
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
          "name": "orgquestion24",
          "title": "Have you received training on organic farming practices?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "orgquestion25",
          "visibleIf": "{question24} = 'Yes'",
          "title": "If yes, specify when and by whom"
        },
        {
          "type": "dropdown",
          "name": "orgquestion26",
          "title": "Do you have access to technical support?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "orgquestion27",
          "visibleIf": "{question26} = 'Yes'",
          "title": "If yes, specify when and by whom"
        },
        {
          "type": "dropdown",
          "name": "orgquestion28",
          "title": "Are you willing to comply with organic certification standards?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "orgquestion29",
          "title": "Are you willing to undergo regular inspections?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "orgquestion30",
          "title": "Do you agree to maintain records of farm activities?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "orgquestion31",
          "title": "I ......., declare that the information provided in this form is accurate to the best of my knowledge.\n2. I commit to following organic farming practices and agree to be part of the internal control system (ICS) for organic certification."
        },
        {
          "type": "panel",
          "name": "photo_panel",
          "title": "Photo of farmer signature\n",
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
          "type": "panel",
          "name": "location_panel",
          "elements": [
            {
              "type": "text",
              "name": "org_location",
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
          "type": "signaturepad",
          "name": "signature",
          "title": "Signature of field agent",
          "isRequired": true
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
//        {
//          "type": "text",
//          "name": "farmer_code",
//          "title": "Farmer code",
//          "isRequired": true
//        },
//        {
//          "type": "panel",
//          "name": "photo_panel",
//          "title": "Photo of ID card\n",
//          "elements": [
//            {
//              "type": "html",
//              "name": "id_photo",
//              "html": "<div id='photo-container' style='text-align: center;'>\
//                <img id='IdPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='ID Card'/>\
//                <button id='getIdPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetIdPhoto()'>Get Photo</button>\
//              </div>"
//            }
//          ]
//        },
//        {
//          "type": "panel",
//          "name": "photo_panel",
//          "title": "Photo of farmer\n",
//          "elements": [
//            {
//              "type": "html",
//              "name": "farmer_photo",
//              "html": "<div id='photo-container' style='text-align: center;'>\
//                <img id='FarmerPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='Farmer Photo'/>\
//                <button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button>\
//              </div>"
//            }
//          ]
//        },
//        {
//          "type": "panel",
//          "name": "photo_panel",
//          "title": "Signature/Thumbprint of farmer\n",
//          "elements": [
//            {
//              "type": "html",
//              "name": "tp_photo",
//              "html": "<div id='photo-container' style='text-align: center;'>\
//                <img id='TpPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='TP Photo'/>\
//                <button id='getTpPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetTpPhoto()'>Get Photo</button>\
//              </div>"
//            }
//          ]
//        },
//        {
//          "type": "signaturepad",
//          "name": "signature",
//          "title": "Agent Signature\n"
//        }
//
//            {
//              "type": "panel",
//              "name": "location_panel",
//              "elements": [
//                {
//                  "type": "text",
//                  "name": "child_location",
//                  "title": "Geo-Location"
//                },
//                {
//                  "type": "html",
//                  "name": "getChildLocation",
//                  "html": "<div style='text-align: center;'><button id='getChildLocation' style='width: 100%; background-color: brown; color: white;' type='button' onclick='handleGetLocation()'>Get Location</button></div>"
//                }
//              ]
//            }

//      ]
//    }
//  ]
//}
