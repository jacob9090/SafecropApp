const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "text",
          "name": "training_code",
          "title": "Training ID",
          "isRequired": true
        },
        {
          "type": "dropdown",
          "name": "district",
          "title": "Select district",
          "isRequired": true,
          "choices": [
            "Adwumapa Cooperative",
            "Anidaso Mmaa Cooperative",
            "Assinman Women",
            "Bitre Cooperative"
          ],
          "otherText": "Other (Specify)"
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
          "otherText": "Other (Specify)"
        },
        {
          "type": "text",
          "name": "training_question1",
          "title": "Date",
          "inputType": "date",
          "isRequired": true
        },
        {
          "type": "text",
          "name": "training_question2",
          "title": "Duration",
          "isRequired": true
        },
        {
          "type": "text",
          "name": "training_question3",
          "title": "Year of Certification",
          "inputType": "number",
          "isRequired": true
        },
        {
          "type": "text",
          "name": "training_question4",
          "title": "Number of male",
          "inputType": "number",
          "isRequired": true
        },
        {
          "type": "text",
          "name": "training_question5",
          "title": "Number of Female",
          "inputType": "number",
          "isRequired": true
        },
        {
          "type": "tagbox",
          "name": "training_question6",
          "title": "Training Topics (Checkbox of all training)",
          "choices": [
            "Basic Understanding Of RA Certification And Importance Of Sustainable Farming",
            "Farmer/Workers Contracting & Agreements",
            "Grievance Mechanisms And Appeal Procedure",
            "Right To Consent",
            "Occupational Health And Safety",
            "First Aid And Emergency Procedures",
            "Climate Smart Agriculture (CSA) (GEP)",
            "Good Agronomic Practices - GAP (Planting And Rotation Including Pruning)",
            "Product Quality And Food Safety",
            "Integrated Pest Management (IPM).",
            "Pest And Diseases Management.",
            "Agrochemical Handling And Usage",
            "Water and Waste Management.",
            "Environment And Ecosysytem Protection",
            "EUDR European Union Deforestation Regulations",
            "Records Keeping",
            "Income Generating Activities",
            "Assess And Address /Grievance Mechanism/ Human Rights"
          ]
        },
        {
          "type": "text",
          "name": "training_question7",
          "title": "Name of Facilitator",
          "isRequired": true
        },
        {
          "type": "panel",
          "name": "training_panel8",
          "title": "TRAINING EVALUATION",
          "elements": [
            {
              "type": "html",
              "name": "training_evaluation",
              "html": "<div style=\"background-color: #A52B2A; color: #FFFFFF; padding: 10px;\"><strong>Instructions:</strong> Please tick your level of agreement with the statements listed below (Strongly Agree 3, Agree 2, Disagree 1)</h5></div>"
            }
          ]
        },
        {
          "type": "slider",
          "name": "training_question8",
          "title": "The objectives of the training were met",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "training_question9",
          "title": "The presenter(s) were engaging",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "training_question10",
          "title": "The presentation materials were relevant",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "training_question11",
          "title": "The course length was appropriate",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "training_question12",
          "title": "The pace of the course was appropriate to the content and attendees",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "training_question13",
          "title": "The exercises/role play were helpful and relevant",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "training_question14",
          "title": "The venue was appropriate for the event",
          "isRequired": true,
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "text",
          "name": "training_question15",
          "title": "Other comments"
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
