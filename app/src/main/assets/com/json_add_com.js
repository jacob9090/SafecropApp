const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "dropdown",
          "name": "commquestion1",
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
          "name": "commquestion2",
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
          "name": "commquestion3",
          "title": "The total population of the community",
          "isRequired": true,
          "choices": [
            "1 - 100",
            "101 - 200",
            "201 - 500",
            "501 - 800",
            "801 - 1000",
            "more than 10000"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion4",
          "title": "Percentage of women in the community who can read and write",
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
          "name": "commquestion5",
          "title": "Are women in this community considered for or involved in leadership roles?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion6",
          "title": "Condition of the nearest road",
          "isRequired": true,
          "choices": [
            "Accessible throughout the year",
            "Partially accessible throughout the year",
            "Not accessible throughout the year"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion7",
          "title": "Presence of electricity",
          "isRequired": true,
          "choices": [
            {
              "value": "Yes",
              "text": "Yes (Connected to the national grid)"
            },
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion8",
          "title": "Connectivity to mobile network",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion9",
          "title": "Is drinking water available in the community?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "tagbox",
          "name": "commquestion10",
          "visibleIf": "{commquestion9} = 'Yes'",
          "title": "If yes, drinking water source?",
          "requiredIf": "{commquestion9} = 'Yes'",
          "choices": [
            "Water supply",
            "Borehole",
            "Pipe-borne",
            "River/Stream",
            "Well",
            "Water pumps"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion11",
          "visibleIf": "{commquestion9} = 'Yes'",
          "title": "How many are functional?",
          "requiredIf": "{commquestion9} = 'Yes'",
          "choices": [
            "1",
            "2",
            "3",
            "4",
            "5 or more"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "commquestion12",
          "visibleIf": "{commquestion9} = 'Yes'",
          "title": "How many are not functional?",
          "requiredIf": "{commquestion9} = 'Yes'",
          "choices": [
            "1",
            "2",
            "3",
            "4",
            "5 or more"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "commquestion13",
          "title": "Are toilets available?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion14",
          "visibleIf": "{commquestion13} = 'Yes'",
          "title": "If yes, in what condition are they?",
          "requiredIf": "{commquestion13} = 'Yes'",
          "choices": [
            "Good",
            "Bad"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion15",
          "title": "Does the community have a market place?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion16",
          "visibleIf": "{commquestion15} = 'Yes'",
          "title": "If yes, what is the condition of the market place?",
          "isRequired": true,
          "requiredIf": "{commquestion15} = 'Yes'",
          "choices": [
            "Good",
            "Bad"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion17",
          "title": "Availability of adult occasional workers (Hired/By-day worker)",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion18",
          "title": "How many public primary schools exist in the community?",
          "isRequired": true,
          "choices": [
            "1",
            "2",
            "3",
            "4",
            "5 or more"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "commquestion19",
          "visibleIf": "{commquestion18} anyof [1, 2, 3, 4, '5 or more']",
          "title": "What is the approximate distance between the community and the nearest primary school? (km)",
          "requiredIf": "{commquestion18} anyof [1, 2, 4, 3, '5 or more']",
          "choices": [
            {
              "value": "0 - 3 km",
              "text": "0 - 1 km"
            },
            {
              "value": "4 - 6 km",
              "text": "2 - 3 km"
            },
            "4 - 5 km",
            "more than 5 km"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion20",
          "title": "How many public Junior High Schools (JHS) exist in the community?",
          "isRequired": true,
          "choices": [
            "1",
            "2",
            "3",
            "4 or more"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "commquestion21",
          "visibleIf": "{commquestion20} anyof [1, 2, 3, '4 or more']",
          "title": "Approximate distance between the community and the nearest Junior High School (JHS)? (km)",
          "requiredIf": "{commquestion20} anyof [1, 2, 3, '4 or more']",
          "choices": [
            "0 - 1 km",
            "2 - 3 km",
            "4 - 5 km",
            "more than 5 km"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion22",
          "title": "Approximate distance between the community and the nearest Senior High School (SHS)? (km)",
          "isRequired": true,
          "choices": [
            "0 - 1 km",
            "2 - 3 km",
            "4 - 5 km",
            "more than 5 km"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion23",
          "title": "Do you know of families in this community whose children are regularly absent from school?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion24",
          "title": "Do you know of families in this community whose children combine school and work?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion25",
          "title": "Are there children in this community who are particularly vulnerable because of their circumstances at home?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion26",
          "title": "Is the community capable of supporting children identified in child labor?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion27",
          "visibleIf": "{commquestion26} = 'Yes'",
          "title": "Please specify what the community does to help these children avoid child labor?",
          "requiredIf": "{commquestion26} = 'Yes'",
          "choices": [
            "sensitise parents",
            "support with school kits",
            "support with money",
            "provide transportation to children",
            "provide food"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion28",
          "title": "Do organisations fighting against the Worst Forms of Child Labor exist in this community?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "tagbox",
          "name": "commquestion29",
          "visibleIf": "{commquestion28} = 'Yes'",
          "title": "If so, what kinds of organisations?",
          "requiredIf": "{commquestion28} = 'Yes'",
          "choices": [
            "Public Organisation",
            "NGO's",
            "Private Organisation"
          ]
        },
        {
          "type": "text",
          "name": "commquestion30",
          "visibleIf": "{commquestion28} = 'Yes'",
          "title": "What are the names of the organisations?",
          "requiredIf": "{commquestion28} = 'Yes'",
          "maxLength": 50
        },
        {
          "type": "checkbox",
          "name": "commquestion31",
          "visibleIf": "{commquestion28} = 'Yes'",
          "title": "What activities do they carry out?",
          "requiredIf": "{commquestion28} = 'Yes'",
          "choices": [
            "Child Protection",
            "Women's Empowerment",
            "Health/Nutrition",
            "Education"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion32",
          "title": "Do you hear of any poor working conditions, poor treatment, or wage-related problems in farms belonging to this community?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion33",
          "title": "Are there facilities in this community that would allow workers to complain about on-farm working conditions safely?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion34",
          "visibleIf": "{commquestion33} = 'Yes'",
          "title": "If yes: Please detail what these facilities are",
          "requiredIf": "{commquestion33} = 'Yes'",
          "choices": [
            "Report to the Police",
            "Report to the Chief",
            "Grievance Committee",
            "Family Head"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion35",
          "title": "Does the farmer group associated in this community have a grievance committee?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion36",
          "title": "Have you heard of farmers in this community referring to this grievance committee for help?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "commquestion37",
          "title": "What other organisations/associations are present in the community?",
          "isRequired": true,
          "maxLength": 50
        },
        {
          "type": "dropdown",
          "name": "commquestion38",
          "title": "Do you know of any situation of sexual violence within a farm related to this community?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion39",
          "visibleIf": "{commquestion38} = 'Yes'",
          "title": "If yes: Please how are these situations dealt with:",
          "requiredIf": "{commquestion38} = 'Yes'",
          "choices": [
            "Report to the police",
            "Report to the Chief",
            "Grievance committee",
            "Family Head"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion40",
          "title": "Do you know if workers are able to complain or report about any mistreatment regarding sexual violence in a safe and effective way?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion41",
          "visibleIf": "{commquestion40} = 'Yes'",
          "title": "If yes: Please to whom is these complaints made:",
          "requiredIf": "{commquestion40} = 'Yes'",
          "choices": [
            "Report to the police",
            "Report to the Chief ",
            "Grievance committee",
            "Family Head"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion42",
          "title": "Is there a Savings and Loans Association (VSLA)",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "commquestion43",
          "visibleIf": "{commquestion42} = 'Yes'",
          "title": "Year of Creation of Savings and Loans Association (VSLA)",
          "requiredIf": "{commquestion42} = 'Yes'",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "commquestion44",
          "visibleIf": "{commquestion42} = 'Yes'",
          "title": "Number of beneficiaries of Savings and Loans Association (VSLA)",
          "requiredIf": "{commquestion42} = 'Yes'",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "commquestion45",
          "visibleIf": "{commquestion42} = 'Yes'",
          "title": "Number of women in the VSLA (who work in VSLA or who are beneficiaries",
          "requiredIf": "{commquestion42} = 'Yes'",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "commquestion46",
          "visibleIf": "{commquestion42} = 'Yes'",
          "title": "Number of men in VSLA (that work in VSLA or that are beneficiaries",
          "requiredIf": "{commquestion42} = 'Yes'",
          "inputType": "number"
        },
        {
          "type": "dropdown",
          "name": "commquestion47",
          "title": "Are there Income generating activities conducted by community members?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "tagbox",
          "name": "commquestion48",
          "visibleIf": "{commquestion47} = 'Yes'",
          "title": "Type of Income-Generating Activities",
          "isRequired": true,
          "requiredIf": "{commquestion47} = 'Yes'",
          "choices": [
            "Food (Crop and Farming)",
            "Breeding Farm",
            "Cosmetics",
            "Soap Making",
            "Food/Crop grinding"
          ]
        },
        {
          "type": "text",
          "name": "commquestion49",
          "visibleIf": "{commquestion47} = 'Yes'",
          "title": "Number of Active Income-Generating Activities",
          "requiredIf": "{commquestion47} = 'Yes'",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "commquestion50",
          "visibleIf": "{commquestion47} = 'Yes'",
          "title": "Year of creation Latest Income Generating Activities",
          "requiredIf": "{commquestion47} = 'Yes'",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "commquestion51",
          "visibleIf": "{commquestion47} = 'Yes'",
          "title": "Number of beneficiaries in Income Generating Activities",
          "requiredIf": "{commquestion47} = 'Yes'",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "commquestion52",
          "visibleIf": "{commquestion47} = 'Yes'",
          "title": "Number of women participants in Income Generating Activities",
          "requiredIf": "{commquestion47} = 'Yes'",
          "inputType": "number"
        },
        {
          "type": "dropdown",
          "name": "commquestion53",
          "visibleIf": "{commquestion47} = 'Yes'",
          "title": "The donors/implementers of the Income Generating Activities",
          "requiredIf": "{commquestion47} = 'Yes'",
          "choices": [
            "Farmer Group",
            "Chocolate Client"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion54",
          "title": "Type of social development activities in the community",
          "isRequired": true,
          "choices": [
            "Construction/Rehabilitation of School",
            "Construction of Borehole",
            "Donation of Tables and Benches"
          ],
          "showOtherItem": true
        },
        {
          "type": "dropdown",
          "name": "commquestion56",
          "title": "Does the community have an active program of restoration and protection of the forests?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion57",
          "title": "Does a community action plan exist?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "tagbox",
          "name": "commquestion58",
          "title": "Are the projects in the community action plan co-financed by the community, farmer groups, local authorities?",
          "isRequired": true,
          "choices": [
            "Community",
            {
              "value": "Farmer Group",
              "text": "Farmer Groups"
            },
            "Local Authorities"
          ],
          "showOtherItem": true
        },
        {
          "type": "dropdown",
          "name": "commquestion59",
          "title": "Has the community received training on advocacy? (Community's rights and needs to the level of government)",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion60",
          "title": "How many schools have been built in the last 3 years?",
          "isRequired": true,
          "choices": [
            "1",
            "2",
            "3",
            "4",
            "5",
            "more than 5"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "commquestion61",
          "title": "Are there days in the week when pupils are not served with food when they go to school (if the school is on the school feeding programme)?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion62",
          "title": "Does a village resource center or an IT center exist?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion63",
          "title": "Are school children supported with school kits, uniforms, school manuals etc in the last 3 years?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion64",
          "title": "Are young people engaged in vocational/professional training after school?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion65",
          "title": "How many young people are supported through apprenticeships?",
          "isRequired": true,
          "choices": [
            {
              "value": "1-15",
              "text": "1 - 15"
            },
            {
              "value": "16-30",
              "text": "16 - 30"
            },
            {
              "value": "31-50",
              "text": "31 - 50"
            },
            "more than 50"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "commquestion66",
          "title": "Does the community have a recreational center for children?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "commquestion67",
          "title": "Do community members use mobile banking services?",
          "isRequired": true,
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
            "name": "com_location",
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
          "title": "Photo",
          "elements": [
          {
            "type": "html",
            "name": "com_photo",
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
  ],
  "showPageTitles": false,
  "showCompletedPage": false,
  "clearInvisibleValues": "onHiddenContainer",
  "completeText": "Save Survey"
}







//const json = {
//  "logoPosition": "right",
//  "pages": [
//    {
//      "name": "page1",
//      "elements": [
//        {
//          "type": "dropdown",
//          "name": "commquestion1",
//          "title": "Select district",
//          "isRequired": true,
//          "choices": [
//            "Nkawie",
//            "Nyinahin"
//          ],
//          "placeholder": "Select..."
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion2",
//          "title": "Select community",
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
//          ],
//          "placeholder": "Select community"
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion3",
//          "title": "The total population of the community",
//          "isRequired": true,
//          "choices": [
//            "1 - 100",
//            "101 - 200",
//            "201 - 500",
//            "501 - 800",
//            "801 - 1000",
//            {
//              "value": "more than 10000",
//              "text": "more than 1000"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion4",
//          "title": "Percentage of women in the community who can read and write",
//          "isRequired": true,
//          "choices": [
//            "0%",
//            "1 - 20 %",
//            "21 - 40%",
//            "41 - 60%",
//            "61 - 80%",
//            "81 - 100%"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion5",
//          "title": "Are women in this community considered for or involved in leadership roles?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion6",
//          "title": "Condition of the nearest road",
//          "isRequired": true,
//          "choices": [
//            "Accessible throughout the year",
//            "Partially accessible throughout the year",
//            "Not accessible throughout the year"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion7",
//          "title": "Presence of electricity",
//          "isRequired": true,
//          "choices": [
//            {
//              "value": "Yes",
//              "text": "Yes (Connected to the national grid)"
//            },
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion8",
//          "title": "Connectivity to mobile network",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion9",
//          "title": "Is drinking water available in the community?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "tagbox",
//          "name": "commquestion10",
//          "visibleIf": "{commquestion9} = 'Yes'",
//          "title": "If yes, drinking water source?",
//          "requiredIf": "{commquestion9} = 'Yes'",
//          "choices": [
//            "Water supply",
//            "Borehole",
//            "Pipe-borne",
//            "River/Stream",
//            "Well",
//            "Water pumps"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion11",
//          "visibleIf": "{commquestion9} = 'Yes'",
//          "title": "How many are functional?",
//          "requiredIf": "{commquestion9} = 'Yes'",
//          "choices": [
//            "1",
//            "2",
//            "3",
//            "4",
//            "5 or more",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion12",
//          "visibleIf": "{commquestion9} = 'Yes'",
//          "title": "How many are not functional?",
//          "requiredIf": "{commquestion9} = 'Yes'",
//          "choices": [
//            "1",
//            "2",
//            "3",
//            "4",
//            "5 or more",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion13",
//          "title": "Are toilets available?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion14",
//          "visibleIf": "{commquestion13} = 'Yes'",
//          "title": "If yes, in what condition are they?",
//          "requiredIf": "{commquestion13} = 'Yes'",
//          "choices": [
//            "Good",
//            "Bad"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion15",
//          "title": "Does the community have a market place?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion16",
//          "visibleIf": "{commquestion15} = 'Yes'",
//          "title": "If yes, what is the condition of the market place?",
//          "isRequired": true,
//          "requiredIf": "{commquestion15} = 'Yes'",
//          "choices": [
//            "Good",
//            "Bad"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion17",
//          "title": "Availability of adult occasional workers (Hired/By-day worker)",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion18",
//          "title": "How many public primary schools exist in the community?",
//          "isRequired": true,
//          "choices": [
//            "1",
//            "2",
//            "3",
//            "4",
//            "5 or more",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion19",
//          "visibleIf": "{commquestion18} anyof [1, 2, 3, 4, '5 or more']",
//          "title": "What is the approximate distance between the community and the nearest primary school? (km)",
//          "requiredIf": "{commquestion18} anyof [1, 2, 4, 3, '5 or more']",
//          "choices": [
//            {
//              "value": "0 - 3 km",
//              "text": "0 - 1 km"
//            },
//            {
//              "value": "4 - 6 km",
//              "text": "2 - 3 km"
//            },
//            "4 - 5 km",
//            "more than 5 km"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion20",
//          "title": "How many public Junior High Schools (JHS) exist in the community?",
//          "isRequired": true,
//          "choices": [
//            "1",
//            "2",
//            "3",
//            "4 or more",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion21",
//          "visibleIf": "{commquestion20} anyof [1, 2, 3, '4 or more']",
//          "title": "Approximate distance between the community and the nearest Junior High School (JHS)? (km)",
//          "requiredIf": "{commquestion20} anyof [1, 2, 3, '4 or more']",
//          "choices": [
//            "0 - 1 km",
//            "2 - 3 km",
//            "4 - 5 km",
//            "more than 5 km"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion22",
//          "title": "Approximate distance between the community and the nearest Senior High School (SHS)? (km)",
//          "isRequired": true,
//          "choices": [
//            "0 - 1 km",
//            "2 - 3 km",
//            "4 - 5 km",
//            "more than 5 km"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion23",
//          "title": "Do you know of families in this community whose children are regularly absent from school?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion24",
//          "title": "Do you know of families in this community whose children combine school and work?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion25",
//          "title": "Are there children in this community who are particularly vulnerable because of their circumstances at home?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion26",
//          "title": "Is the community capable of supporting children identified in child labor?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion27",
//          "visibleIf": "{commquestion26} = 'Yes'",
//          "title": "Please specify what the community does to help these children avoid child labor?",
//          "requiredIf": "{commquestion26} = 'Yes'",
//          "choices": [
//            "sensitise parents",
//            "support with school kits",
//            "support with money",
//            "provide transportation to children",
//            "provide food",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion28",
//          "title": "Do organisations fighting against the Worst Forms of Child Labor exist in this community?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "tagbox",
//          "name": "commquestion29",
//          "visibleIf": "{commquestion28} = 'Yes'",
//          "title": "If so, what kinds of organisations?",
//          "requiredIf": "{commquestion28} = 'Yes'",
//          "choices": [
//            "Public Organisation",
//            "NGO's",
//            "Private Organisation"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "commquestion30",
//          "visibleIf": "{commquestion28} = 'Yes'",
//          "title": "What are the names of the organisations?",
//          "requiredIf": "{commquestion28} = 'Yes'",
//          "maxLength": 50
//        },
//        {
//          "type": "checkbox",
//          "name": "commquestion31",
//          "visibleIf": "{commquestion28} = 'Yes'",
//          "title": "What activities do they carry out?",
//          "requiredIf": "{commquestion28} = 'Yes'",
//          "choices": [
//            "Child Protection",
//            "Women's Empowerment",
//            "Health/Nutrition",
//            "Education"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion32",
//          "title": "Do you hear of any poor working conditions, poor treatment, or wage-related problems in farms belonging to this community?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion33",
//          "title": "Are there facilities in this community that would allow workers to complain about on-farm working conditions safely?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion34",
//          "visibleIf": "{commquestion33} = 'Yes'",
//          "title": "If yes: Please detail what these facilities are",
//          "requiredIf": "{commquestion33} = 'Yes'",
//          "choices": [
//            "Report to the Police",
//            "Report to the Chief",
//            "Grievance Committee",
//            "Family Head",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion35",
//          "title": "Does the farmer group associated in this community have a grievance committee?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion36",
//          "title": "Have you heard of farmers in this community referring to this grievance committee for help?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "commquestion37",
//          "title": "What other organisations/associations are present in the community?",
//          "isRequired": true,
//          "maxLength": 50
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion38",
//          "title": "Do you know of any situation of sexual violence within a farm related to this community?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion39",
//          "visibleIf": "{commquestion38} = 'Yes'",
//          "title": "If yes: Please how are these situations dealt with:",
//          "requiredIf": "{commquestion38} = 'Yes'",
//          "choices": [
//            "Report to the police",
//            "Report to the Chief",
//            "Grievance committee",
//            "Family Head",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion40",
//          "title": "Do you know if workers are able to complain or report about any mistreatment regarding sexual violence in a safe and effective way?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion41",
//          "visibleIf": "{commquestion40} = 'Yes'",
//          "title": "If yes: Please to whom is these complaints made:",
//          "requiredIf": "{commquestion40} = 'Yes'",
//          "choices": [
//            "Report to the police",
//            "Report to the Chief ",
//            "Grievance committee",
//            "Family Head",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion42",
//          "title": "Is there a Savings and Loans Association (VSLA)",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "commquestion43",
//          "visibleIf": "{commquestion42} = 'Yes'",
//          "title": "Year of Creation of Savings and Loans Association (VSLA)",
//          "requiredIf": "{commquestion42} = 'Yes'",
//          "inputType": "number"
//        },
//        {
//          "type": "text",
//          "name": "commquestion44",
//          "visibleIf": "{commquestion42} = 'Yes'",
//          "title": "Number of beneficiaries of Savings and Loans Association (VSLA)",
//          "requiredIf": "{commquestion42} = 'Yes'",
//          "inputType": "number"
//        },
//        {
//          "type": "text",
//          "name": "commquestion45",
//          "visibleIf": "{commquestion42} = 'Yes'",
//          "title": "Number of women in the VSLA (who work in VSLA or who are beneficiaries",
//          "requiredIf": "{commquestion42} = 'Yes'",
//          "inputType": "number"
//        },
//        {
//          "type": "text",
//          "name": "commquestion46",
//          "visibleIf": "{commquestion42} = 'Yes'",
//          "title": "Number of men in VSLA (that work in VSLA or that are beneficiaries",
//          "requiredIf": "{commquestion42} = 'Yes'",
//          "inputType": "number"
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion47",
//          "title": "Are there Income generating activities conducted by community members?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion48",
//          "visibleIf": "{commquestion47} = 'Yes'",
//          "title": "Type of Income-Generating Activities",
//          "isRequired": true,
//          "requiredIf": "{commquestion47} = 'Yes'",
//          "choices": [
//            "Food (Crop and Farming)",
//            "Breeding Farm",
//            "Cosmetics",
//            "Soap Making",
//            "Food/Crop grinding",
//            "None"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "commquestion49",
//          "visibleIf": "{commquestion47} = 'Yes'",
//          "title": "Number of Active Income-Generating Activities",
//          "requiredIf": "{commquestion47} = 'Yes'",
//          "inputType": "number"
//        },
//        {
//          "type": "text",
//          "name": "commquestion50",
//          "visibleIf": "{commquestion47} = 'Yes'",
//          "title": "Year of creation Latest Income Generating Activities",
//          "requiredIf": "{commquestion47} = 'Yes'",
//          "inputType": "number"
//        },
//        {
//          "type": "text",
//          "name": "commquestion51",
//          "visibleIf": "{commquestion47} = 'Yes'",
//          "title": "Number of beneficiaries in Income Generating Activities",
//          "requiredIf": "{commquestion47} = 'Yes'",
//          "inputType": "number"
//        },
//        {
//          "type": "text",
//          "name": "commquestion52",
//          "visibleIf": "{commquestion47} = 'Yes'",
//          "title": "Number of women participants in Income Generating Activities",
//          "requiredIf": "{commquestion47} = 'Yes'",
//          "inputType": "number"
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion53",
//          "visibleIf": "{commquestion47} = 'Yes'",
//          "title": "The donors/implementers of the Income Generating Activities",
//          "requiredIf": "{commquestion47} = 'Yes'",
//          "choices": [
//            "Farmer Group",
//            "Chocolate Client",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion54",
//          "title": "Type of social development activities in the community",
//          "isRequired": true,
//          "choices": [
//            "Construction/Rehabilitation of School",
//            "Construction of Borehole",
//            "Donation of Tables and Benches",
//            "Others"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion56",
//          "title": "Does the community have an active program of restoration and protection of the forests?",
//          "isRequired": true,
//          "choices": [
//            {
//              "value": "Item 1",
//              "text": "Yes"
//            },
//            {
//              "value": "Item 2",
//              "text": "No"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion57",
//          "title": "Does a community action plan exist?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "tagbox",
//          "name": "commquestion58",
//          "title": "Are the projects in the community action plan co-financed by the community, farmer groups, local authorities?",
//          "isRequired": true,
//          "choices": [
//            "Community",
//            {
//              "value": "Farmer Group",
//              "text": "Farmer Groups"
//            },
//            "Local Authorities",
//            "Others"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion59",
//          "title": "Has the community received training on advocacy? (Community's rights and needs to the level of government)",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion60",
//          "title": "How many schools have been built in the last 3 years?",
//          "isRequired": true,
//          "choices": [
//            "1",
//            "2",
//            "3",
//            "4",
//            "5",
//            "more than 5",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion61",
//          "title": "Are there days in the week when pupils are not served with food when they go to school (if the school is on the school feeding programme)?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion62",
//          "title": "Does a village resource center or an IT center exist?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion63",
//          "title": "Are school children supported with school kits, uniforms, school manuals etc in the last 3 years?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion64",
//          "title": "Are young people engaged in vocational/professional training after school?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion65",
//          "title": "How many young people are supported through apprenticeships?",
//          "isRequired": true,
//          "choices": [
//            {
//              "value": "1-15",
//              "text": "1 - 15"
//            },
//            {
//              "value": "16-30",
//              "text": "16 - 30"
//            },
//            {
//              "value": "31-50",
//              "text": "31 - 50"
//            },
//            "more than 50",
//            "None"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion66",
//          "title": "Does the community have a recreational center for children?",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "commquestion67",
//          "title": "Do community members use mobile banking services?",
//          "isRequired": true,
//          "choices": [
//            {
//              "value": "Item 1",
//              "text": "Yes"
//            },
//            {
//              "value": "Item 2",
//              "text": "No"
//            }
//          ]
//        },
//        {
//          "type": "panel",
//          "name": "location_panel",
//          "elements": [
//            {
//              "type": "text",
//              "name": "com_location",
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
//              "name": "com_photo",
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
//  ],
//  "showPageTitles": false,
//  "showCompletedPage": false,
//  "clearInvisibleValues": "onHiddenContainer",
//  "completeText": "Save Survey"
//}









//const json = {
//  "logoPosition": "right",
//  "pages": [
//    {
//      "name": "page1",
//      "elements": [
//      {
//        "type": "text",
//        "name": "com_name",
//        "title": "Name of School",
//        "maxLength": 50
//      },
//        {
//          "type": "dropdown",
//          "name": "com_district",
//          "title": "Name of district.",
//          "choices": [
//            "District1",
//            "District2"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "com_community",
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
//              "name": "com_location",
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
//              "name": "com_photo",
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