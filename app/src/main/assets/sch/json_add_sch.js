const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "dropdown",
          "name": "sch_district",
          "title": "Name of district.",
          "isRequired": true,
          "choices": [
           "Bechem",
           "Tepa"
          ]
        },
        {
          "type": "dropdown",
          "name": "sch_community",
          "title": " Select community",
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
          ]
        },
        {
          "type": "text",
          "name": "sch_name",
          "title": "Name of School",
          "isRequired": true,
          "maxLength": 100
        },
        {
          "type": "text",
          "name": "schquestion4",
          "title": "Date of School Establishment",
          "inputType": "date"
        },
        {
          "type": "text",
          "name": "schquestion5",
          "title": "Name of child protection manager",
          "isRequired": true,
          "maxLength": 100
        },
        {
          "type": "dropdown",
          "name": "schquestion6",
          "title": "Type of school",
          "isRequired": true,
          "choices": [
            "Primary",
            "Junior High School",
            "Senior High School",
            "Primary and JHS"
          ]
        },
        {
          "type": "text",
          "name": "schquestion7",
          "title": "What is the school's pupil/student enrollment capacity",
          "isRequired": true,
          "inputType": "number",
          "min": 1,
          "max": 9000
        },
        {
          "type": "text",
          "name": "schquestion8",
          "title": "How many people make up the school staff?",
          "isRequired": true,
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "schquestion9",
          "title": "Number of male pupils/students",
          "isRequired": true,
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "schquestion10",
          "title": "Number of female pupils/students",
          "isRequired": true,
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "schquestion11",
          "title": "How many classrooms does the school have?",
          "isRequired": true,
          "inputType": "number"
        },
        {
          "type": "dropdown",
          "name": "schquestion12",
          "title": "Average pass rate in BECE or WASSCE (previous year)",
          "isRequired": true,
          "choices": [
            "0%",
            "1%-20%",
            "21%-40%",
            "41%-60%",
            "61%-80%",
            "81%-100%"
          ]
        },
        {
          "type": "text",
          "name": "schquestion13",
          "title": "Number of teachers provided by the state",
          "isRequired": true,
          "inputType": "number",
          "min": 0,
          "max": 50
        },
        {
          "type": "text",
          "name": "schquestion14",
          "title": "Number of volunteer teachers",
          "isRequired": true,
          "inputType": "number",
          "min": 0,
          "max": 50
        },
        {
          "type": "dropdown",
          "name": "schquestion15",
          "title": "Do pupils/students need birth certificates to be enrolled in the school?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "schquestion16",
          "title": "Percentage of students with birth certificate/eqv. document",
          "choices": [
            "0%",
            "1-20%",
            "21-40%",
            "41-60%",
            "61-80%",
            "81-100%"
          ]
        },
        {
          "type": "dropdown",
          "name": "schquestion17",
          "title": "Does the school have a canteen?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "schquestion18",
          "title": "Does the school have a school feeding program?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "schquestion19",
          "title": "What is students school attendance rate during cocoa harvesting period?",
          "choices": [
            "0%",
            "1-20%",
            "21-40%",
            "41-60%",
            "61-80%",
            "81-100%"
          ]
        },
        {
          "type": "dropdown",
          "name": "schquestion20",
          "title": "What is students school attendance rate outside cocoa harvesting period?",
          "isRequired": true,
          "choices": [
            "0%",
            "1 - 20 %",
            "21 - 40%",
            "41 - 60%",
            "61 - 80%",
            "81 - 100%"
          ]
        },
        {
          "type": "dropdown",
          "name": "schquestion21",
          "title": "Do you think certain children work while being in school?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "schquestion22",
          "visibleIf": "{schquestion21} = 'Yes'",
          "title": " If yes, which type of work do you think they are involved in?",
          "isRequired": true,
          "choices": [
            "agriculture",
            "cocoaculture",
            "domestic",
            "commercial",
            "extra-curricular"
          ]
        },
        {
          "type": "dropdown",
          "name": "schquestion23",
          "title": "During what periods?",
          "choices": [
            "school days",
            "non-school days",
            "week-end",
            "vacation",
            "cocoa harvest period"
          ]
        },
        {
          "type": "text",
          "name": "schquestion24",
          "title": "According to you, for what reasons do the children in this community work",
          "maxLength": 100
        },
        {
          "type": "dropdown",
          "name": "schquestion25",
          "title": "How many schools have been renovated in the last 3 years?",
          "choices": [
            "1",
            "2",
            "3",
            "more than 3"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "schquestion26",
          "title": "How many classrooms have been renovated in the last 3 years?",
          "choices": [
            "1",
            "2",
            "3",
            "more than 3"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "schquestion27",
          "title": "How many schools have received supplies in the past 3 years?",
          "choices": [
            "1",
            "2",
            "3",
            "more than 3"
          ],
          "showNoneItem": true
        },
        {
          "type": "tagbox",
          "name": "schquestion28",
          "title": "What are the supplies?",
          "choices": [
            "school uniforms",
            "books",
            "desks and chairs",
            "computers"
          ],
          "showOtherItem": true,
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "schquestion29",
          "title": "How many teacher bungalows are available?",
          "choices": [
            "1",
            "2",
            "3",
            "more than 3"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "schquestion30",
          "title": "How many school canteens have been renovated or built?",
          "choices": [
            "1",
            "2",
            "3",
            "more than 3"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "schquestion31",
          "title": "Is the public school in your community signed on to the school feeding programme?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "schquestion32",
          "title": "Does a school management committee exist?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "schquestion33",
          "title": "Does a parent-teacher association exist?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "schquestion34",
          "title": "Address of the school",
          "maxLength": 100
        },
        {
          "type": "panel",
          "name": "location_panel",
          "elements": [
            {
              "type": "text",
              "name": "sch_location",
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
              "name": "sch_photo",
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
//          "type": "dropdown",
//          "name": "sch_name",
//          "title": "Name of district.",
//          "isRequired": true,
//          "choices": [
//            "Nkawie",
//            "Nyinahin"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "sch_district",
//          "title": " Select community",
//          "isRequired": true,
//          "choices": [
//            "Abaasua",
//            "Adankwame",
//            "Adupr-A",
//            "Adupr-B",
//            "Ahodwo",
//            "Akantansu Nkwanta",
//            "Akantansu-B",
//            "Akonkye B",
//            "Akonkye-A",
//            "Akonkye-B",
//            "Akonkye-C",
//            "Akorabokrom",
//            "Amadaa",
//            "Ampoma",
//            "Anyinamso",
//            "Anyinasa-A",
//            "Anyinasa-B",
//            "Anyinasa-C",
//            "Beposo",
//            "Berimayena",
//            "Berimayena-B",
//            "Betinko",
//            "Boboso",
//            "Bontomuroso-B",
//            "Bontomuruso-A",
//            "Esaase Manhyia",
//            "Gogoikrom",
//            "Gogoikrom-B",
//            "Huntaado",
//            "Kantinkyiren",
//            "Kantinkyiren-B",
//            "Kataakyiwa-A",
//            "Kofihiakrom-A",
//            "Konkonkor-A",
//            "Konkonkor-B",
//            "Krofrom",
//            "Kukubuso",
//            "Kumi",
//            "Kwaku Mire",
//            "Kwanfinfi",
//            "Kwankyeabo",
//            "Kwankyeabo-B",
//            "Kyekyerekrom",
//            "Mansaso-B",
//            "Medidwa",
//            "Mpasatia",
//            "Mpawe",
//            "Nerebehi",
//            "Nkrumah",
//            "Nkyekyenso",
//            "Nyamebekyere-B",
//            "Pakyi",
//            "Pakyi-B",
//            "Saakrom",
//            "Sebekrom",
//            "Seidi"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "sch_community",
//          "title": "Name of School",
//          "isRequired": true,
//          "maxLength": 50
//        },
//        {
//          "type": "text",
//          "name": "schquestion4",
//          "title": "Date of School Establishment",
//          "inputType": "date"
//        },
//        {
//          "type": "text",
//          "name": "schquestion5",
//          "title": "Name of child protection manager",
//          "isRequired": true,
//          "maxLength": 40
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion6",
//          "title": "Type of school",
//          "isRequired": true,
//          "choices": [
//            "Primary",
//            "Junior High School",
//            "Senior High School"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "schquestion7",
//          "title": "What is the school's pupil/student enrollment capacity",
//          "isRequired": true,
//          "inputType": "number",
//          "min": 1,
//          "max": 1000
//        },
//        {
//          "type": "text",
//          "name": "schquestion8",
//          "title": "How many people make up the school staff?",
//          "isRequired": true,
//          "inputType": "number"
//        },
//        {
//          "type": "text",
//          "name": "schquestion9",
//          "title": "Number of male pupils/students",
//          "isRequired": true,
//          "inputType": "number"
//        },
//        {
//          "type": "text",
//          "name": "schquestion10",
//          "title": "Number of female pupils/students",
//          "isRequired": true,
//          "inputType": "number"
//        },
//        {
//          "type": "text",
//          "name": "schquestion11",
//          "title": "How many classrooms does the school have?",
//          "isRequired": true,
//          "inputType": "number"
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion12",
//          "title": "Average pass rate in BECE or WASSCE (previous year)",
//          "isRequired": true,
//          "choices": [
//            "0%",
//            "1%-20%",
//            "21%-40%",
//            "41%-60%",
//            "61%-80%",
//            "81%-100%"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "schquestion13",
//          "title": "Number of teachers provided by the state",
//          "isRequired": true,
//          "inputType": "number",
//          "min": 0,
//          "max": 15
//        },
//        {
//          "type": "text",
//          "name": "schquestion14",
//          "title": "Number of volunteer teachers",
//          "isRequired": true,
//          "inputType": "number",
//          "min": 0,
//          "max": 10
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion15",
//          "title": "Do pupils/students need birth certificates to be enrolled in the school?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion16",
//          "title": "Percentage of students with birth certificate/eqv. document",
//          "choices": [
//            {
//              "value": "Item 1",
//              "text": "0%"
//            },
//            {
//              "value": "Item 2",
//              "text": "1-20%"
//            },
//            {
//              "value": "Item 3",
//              "text": "21-40%"
//            },
//            {
//              "value": "Item 4",
//              "text": "41-60%"
//            },
//            {
//              "value": "Item 5",
//              "text": "61-80%"
//            },
//            {
//              "value": "Item 6",
//              "text": "81-100%"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion17",
//          "title": "Does the school have a canteen?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion18",
//          "title": "Does the school have a school feeding program?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion19",
//          "title": "What is students school attendance rate during cocoa harvesting period?",
//          "choices": [
//            "0%",
//            "1-20%",
//            "21-40%",
//            "41-60%",
//            "61-80%",
//            "81-100%"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion20",
//          "title": "What is students school attendance rate outside cocoa harvesting period?",
//          "isRequired": true,
//          "choices": [
//            "0%",
//            "1 - 20 %",
//            "21 - 40%",
//            "41-60%",
//            "61-80%",
//            "81-100%"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion21",
//          "title": "Do you think certain children work while being in school?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion22",
//          "visibleIf": "{schquestion21} = 'Yes'",
//          "title": " If yes, which type of work do you think they are involved in?",
//          "isRequired": true,
//          "choices": [
//            "agriculture",
//            "cocoaculture",
//            "domestic",
//            "commercial",
//            "extra-curricular"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion23",
//          "title": "During what periods?",
//          "choices": [
//            {
//              "value": "Item 1",
//              "text": "school days"
//            },
//            {
//              "value": "Item 2",
//              "text": "non-school days"
//            },
//            {
//              "value": "Item 4",
//              "text": "week-end"
//            },
//            {
//              "value": "Item 3",
//              "text": "vacation"
//            },
//            {
//              "value": "Item 5",
//              "text": "cocoa harvest period\""
//            }
//          ]
//        },
//        {
//          "type": "text",
//          "name": "schquestion24",
//          "title": "According to you, for what reasons do the children in this community work",
//          "maxLength": 40
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion25",
//          "title": "How many schools have been renovated in the last 3 years?",
//          "choices": [
//            "0",
//            "1",
//            "2",
//            "3",
//            "more than 3",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion26",
//          "title": "How many classrooms have been renovated in the last 3 years?",
//          "choices": [
//            "0",
//            "1",
//            "2",
//            "3",
//            "more than 3",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion27",
//          "title": "How many schools have received supplies in the past 3 years?",
//          "choices": [
//            "0",
//            "1",
//            "2",
//            "3",
//            "more than 3",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion28",
//          "title": "What are the supplies?",
//          "choices": [
//            "school uniforms",
//            "books",
//            "desks and chairs",
//            "computers",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion29",
//          "title": "How many teacher bungalows are available?",
//          "choices": [
//            "0",
//            "1",
//            "2",
//            "3",
//            "more than 3",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion30",
//          "title": "How many school canteens have been renovated or built?",
//          "choices": [
//            "0",
//            "1",
//            "2",
//            "3",
//            "more than 3",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion31",
//          "title": "Is the public school in your community signed on to the school feeding programme?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion32",
//          "title": "Does a school management committee exist?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion33",
//          "title": "Does a parent-teacher association exist?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "schquestion34",
//          "title": "Address of the school",
//          "maxLength": 15
//        },
//        {
//          "type": "panel",
//          "name": "location_panel",
//          "elements": [
//            {
//              "type": "text",
//              "name": "sch_location",
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
//              "name": "sch_photo",
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







//const json = {
//  "logoPosition": "right",
//  "pages": [
//    {
//      "name": "page1",
//      "elements": [
//      {
//        "type": "text",
//        "name": "sch_name",
//        "title": "Name of School",
//        "maxLength": 50
//      },
//        {
//          "type": "dropdown",
//          "name": "sch_district",
//          "title": "Name of district.",
//          "choices": [
//            "District1",
//            "District2"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "sch_community",
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
//              "name": "sch_location",
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
//              "name": "sch_photo",
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