const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "text",
          "name": "farmer_id",
          "title": "UserID",
          "isRequired": true,
          "readOnly": true
        },
        {
          "type": "dropdown",
          "name": "district",
          "title": "Select district",
          "isRequired": true,
          "choices": [
            "Adwumapa Coorperative",
            "Anidaso Mmaa Coorperative",
            "Assinman Women",
            "Bitre Cooperative"
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
            "Abebresekrom",
            "Abechem",
            "Abekoase",
            "Abole",
            "Abotareye",
            "Adiepena",
            "Adukrom",
            "Agoloso",
            "Alhassankrom",
            "Amoakrom",
            "Anhweasu",
            "Aniakragya",
            "Ankaase",
            "Apesika",
            "Apotoyewa",
            "Appiahkrom",
            "Arkofudi Patasi",
            "Asenchem",
            "Asibrem",
            "Assin Abodwese",
            "Assin Akropong Wawase",
            "Assin Dwanakye Adwanpa",
            "Assin Krofofrom",
            "Assin Kyeikrom",
            "Assin Nkukuasa",
            "Assin Ntowkrom",
            "Assin Nyamebekyere",
            "Assin Sabena",
            "Assin Sienkyem",
            "Assin Swedru",
            "Assin Yaw Saman",
            "Assin Zamboli",
            "Asuadai",
            "Asukaiss",
            "Atentan",
            "Atwerboanda",
            "Aworabo",
            "Aworkrom",
            "Ayitey",
            "Basofi Ningo",
            "Bomaa",
            "Brosankro",
            "Brosankro Old Town",
            "Daudakrom",
            "Dechem",
            "Derma",
            "Derma Nkwankyire",
            "Dumakwai",
            "Dwomo",
            "Fawobotoso",
            "Fianko",
            "Gambia",
            "Ghana Camp",
            "Gold Coast Camp",
            "Jacobu",
            "Kadadwen",
            "Kadonko",
            "Katapei",
            "Kensere",
            "Kojomiakrom",
            "Kramokrom",
            "Kruboa",
            "Kusuogya",
            "Kwadwoaddaekrom",
            "Kwaku Dua Krom",
            "Kwamemensahkrom",
            "Kwantene",
            "Kyekyewere",
            "Mampong",
            "Manteykrom",
            "Mfante",
            "Mim",
            "Montwi",
            "Nkrankrom",
            "Nuamakrom",
            "Nuanua Mampong",
            "Nyankomago",
            "Ohiaanimguase",
            "Ohiantua",
            "Olumankrom",
            "Pokua",
            "Pokuakura",
            "Subompang",
            "Sumsei",
            "Tanokrom",
            "Techimantia",
            "Techimantia B",
            "Tuagyankrom",
            "Twifo Aboso",
            "Twifo Afosua",
            "Twifo Akweikrom",
            "Twifo Ekurakese",
            "Twifo Kenkuase",
            "Yawkrakrom"
          ],
          "showOtherItem": true,
          "otherText": "Other (Community)"
        },
        {
          "type": "dropdown",
          "name": "suspro_question1",
          "title": "Which cooperative do you belong in",
          "choices": [
            "Anidaso Cooperative",
            "Anidaso Mmaa",
            "After Two"
          ]
        },
        {
          "type": "dropdown",
          "name": "suspro_question2",
          "title": "Varieties of cocoa",
          "choices": [
            "Hybrid",
            "Amazonia",
            "Mixed"
          ]
        },
        {
          "type": "text",
          "name": "suspro_question3",
          "title": "Farmer name",
          "isRequired": true
        },
        {
          "type": "dropdown",
          "name": "suspro_question4",
          "title": "Do you have a valid identification card",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "suspro_question4b",
          "visibleIf": "{suspro_question4} = 'Yes'",
          "title": "Identification card type",
          "choices": [
            "Ghana card",
            "Cocoboad card"
          ],
          "showOtherItem": true
        },
        {
          "type": "text",
          "name": "suspro_question4c",
          "visibleIf": "{suspro_question4} = 'Yes'",
          "title": "ID Number"
        },
        {
          "type": "dropdown",
          "name": "suspro_question5",
          "title": "Gender",
          "isRequired": true,
          "choices": [
            "Male",
            "Female"
          ]
        },
        {
          "type": "text",
          "name": "suspro_question6",
          "title": "Date of birth",
          "inputType": "date",
          "min": "1900-01-01",
          "max": "2010-01-01"
        },
        {
          "type": "dropdown",
          "name": "suspro_question7",
          "title": "Do you have a registered SIM card",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "suspro_question7b",
          "visibleIf": "{suspro_question7} = 'Yes'",
          "title": "SIM Number"
        },
        {
          "type": "dropdown",
          "name": "suspro_question8",
          "title": "Do you have a registered mobile money number",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "suspro_question8b",
          "visibleIf": "{suspro_question8} = 'Yes'",
          "title": "MoMo number"
        },
        {
          "type": "dropdown",
          "name": "suspro_question9",
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
          "name": "suspro_question10",
          "title": "Total number of members living in the household?",
          "inputType": "number",
          "isRequired": true
        },
        {
          "type": "dropdown",
          "name": "suspro_question11",
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
          "name": "suspro_question11b",
          "visibleIf": "{suspro_question11} anyof [2, 1, 3, 4, 5, 6, 7, 8, 9, 10]",
          "title": "How many of the children mentioned above are of school-going age (5 to 17 years)?"
        },
        {
          "type": "text",
          "name": "suspro_question11c",
          "visibleIf": "{suspro_question11} anyof [1, 2, 3, 4, 5, 6, 8, 7, 9, 10]",
          "title": "How many of the school-going children (aged 5 to 17) are currently enrolled in school?",
          "inputType": "number"
        },
        {
          "type": "panel",
          "name": "genderdistributionpanel",
          "visibleIf": "{suspro_question11} anyof [1, 3, 2, 4, 5, 6, 7, 8, 9, 10]",
          "title": "What is the gender distribution of the children in the household? Please specify the number of boys and girls. (0 - 17)",
          "elements": [
            {
              "type": "text",
              "name": "suspro_question12",
              "title": "Male",
              "inputType": "number"
            },
            {
              "type": "text",
              "name": "suspro_question12b",
              "title": "Female",
              "inputType": "number"
            }
          ]
        },
        {
          "type": "text",
          "name": "suspro_question13",
          "title": "How many cocoa plots do you have?\n",
          "inputType": "number",
          "isRequired": true
        },
        {
          "type": "dropdown",
          "name": "suspro_question14",
          "title": "Do you have any other plots?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "suspro_question14b",
          "visibleIf": "{suspro_question14} = 'Yes'",
          "title": "How many plots do you have?\n",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "suspro_question14c",
          "visibleIf": "{suspro_question14} = 'Yes'",
          "title": "What are the acreages of your plots?\r\n"
        },
        {
          "type": "tagbox",
          "name": "suspro_question14d",
          "visibleIf": "{suspro_question14} = 'Yes'",
          "title": "What type of crop do you grow on the plots?\n",
          "choices": [
            "Vegetables",
            "Food crop",
            "Cash crop"
          ]
        },
        {
          "type": "dropdown",
          "name": "suspro_question15",
          "title": "Do you apply pesticides?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "suspro_question15b",
          "visibleIf": "{suspro_question15} = 'Yes'",
          "title": "How many times do you apply it in a season?\r\n",
          "choices": [
            "Once a year",
            "2-4 times a year",
            "More than 4 times a year"
          ]
        },
        {
          "type": "dropdown",
          "name": "suspro_question16",
          "title": "Do you apply fungicides?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "suspro_question16b",
          "visibleIf": "{suspro_question16} = 'Yes'",
          "title": "How many times do you apply it in a season?\r\n",
          "choices": [
            "Once a year",
            "2-4 times a year",
            "More than 4 times a year"
          ]
        },
        {
          "type": "dropdown",
          "name": "suspro_question17",
          "title": "Do you use organic fertilizer?\r\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "suspro_question17b",
          "visibleIf": "{suspro_question17} = 'Yes'",
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
          "name": "suspro_question17c",
          "visibleIf": "{suspro_question17} = 'Yes'",
          "title": "How many times do you apply it in a season?\r\n",
          "choices": [
            "Once a year",
            "2-4 times a year",
            "More than 4 times a year"
          ]
        },
        {
          "type": "text",
          "name": "suspro_question18",
          "title": "How many bags of cocoa did you produce/harvest last season 24/25?\r\n"
        },
        {
          "type": "text",
          "name": "suspro_question19",
          "title": "How many bags of cocoa do you estimate to produce this season 25/26?\r\n"
        },
        {
          "type": "dropdown",
          "name": "suspro_question20",
          "title": "Is your farm located near a high conservation area (forest)\r\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "suspro_question21",
          "title": "Do you agree to work with safe crop Agricultural services and will abide by all internal rules and standards the group\r\n",
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
              "name": "suspro_location",
              "title": "Geolocation of farm",
              "isRequired": true,
              "readOnly": true
            },
            {
              "type": "html",
              "name": "getSusProLocation",
              "html": "<div id='location-container' style='text-align: center;'><button id='getInspectionLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button></div>"
            }
          ]
        },
        {
          "type": "panel",
          "name": "photo_panel",
          "title": "Farmer thumbprint",
          "elements": [
            {
              "type": "html",
              "name": "suspro_photo",
              "html": "<div id='photo-container' style='text-align: center;'><img id='FarmerPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='Farmer Photo'/><button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button></div>"
            }
          ]
        },
        {
          "type": "signaturepad",
          "name": "signature",
          "title": "Signature of enumerator",
          "isRequired": true,
          "signatureWidth": 600
        }
      ]
    }
  ]
}
