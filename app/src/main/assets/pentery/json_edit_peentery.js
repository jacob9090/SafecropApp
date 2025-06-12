const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "text",
          "name": "orgquestion1",
          "title": "Farmer's Name",
          "isRequired": true
        },
        {
          "type": "dropdown",
          "name": "orgquestion2",
          "title": "Gender",
          "isRequired": true,
          "choices": [
            "Male",
            "Female"
          ]
        },
        {
          "type": "text",
          "name": "orgquestion3",
          "title": "Date of Birth",
          "isRequired": true,
          "inputType": "date"
        },
        {
          "type": "dropdown",
          "name": "orgquestion4",
          "title": "Select district",
          "choices": [
            "Atobiase",
            "Juaso",
            "Konongo",
            "Konongo B",
            "New Edubiase",
            "Nkawkaw",
            "Twifo Praso"
          ]
        },
        {
          "type": "dropdown",
          "name": "orgquestion5",
          "title": "Select community",
          "choices": [
            "Aboaboso",
            "Achiase",
            "Adampansu",
            "Adiembra",
            "Adumasa",
            "Adumkrom",
            "Ajarago",
            "Akokobenom",
            "Akuakrom",
            "Amanfrom",
            "Amantena",
            "Anorwokrom",
            "Anunruso",
            "Anweaso",
            "Anyanso",
            "Anyenase",
            "Appiahkrom",
            "Asisiriwa",
            "Asiwa",
            "Asuboni",
            "Asuoho Mim",
            "Banka",
            "Bankame",
            "Beposo",
            "Boamadumase",
            "Boatengkrom",
            "Bobiem",
            "Bomfa",
            "Bomireso",
            "Breku-Camp",
            "Brofoyedru",
            "Duapompo",
            "Dwease",
            "Dwease-praso",
            "Dwendwenase",
            "Esaase",
            "Juaso",
            "Kokobeng",
            "Konongo",
            "Konongo Bankame",
            "Konongo Yawkwei",
            "Kramokrom",
            "Kyekyebiase",
            "Kyempo",
            "Lake",
            "New Koforidua",
            "Nkwanta",
            "Nobewam",
            "Noyem",
            "Nsiahkrom",
            "Nwinso",
            "Obenemase",
            "Odumase",
            "Onaa",
            "Osubeng",
            "Pankese",
            "Pekyerekyer",
            "Peminase",
            "Policekrom",
            "Praso",
            "Shell",
            "Tiawia",
            "Wabiri",
            "Wankyi",
            "White House",
            "Wioso",
            "Yapesa",
            "Yawkwei",
            "Abankwa",
            "Aboabo",
            "Afiaso",
            "Aframoase",
            "Agogooso",
            "Ansa",
            "Asamanfoum",
            "Ataase",
            "Dotom",
            "Duapompo",
            "Fumso",
            "KAKRA",
            "Keteke",
            "Kojo Ntumi",
            "Menang",
            "Mossikrom",
            "New Edubiase",
            "Nsese",
            "Nsuta",
            "Nsuta Aboagye",
            "NYAMEBEKYERE",
            "Nyamekrom",
            "Nyankomase",
            "Perweiso",
            "Sikaman",
            "Taylorkrom",
            "Yaw Biri",
            "Adade-kofi",
            "Akotosu",
            "Amponsaso",
            "Apenkro Shed",
            "Appeasumang",
            "Asare Kwaku",
            "Atobiase A",
            "Atobiase-Subriso",
            "Atwebesa",
            "Awisem",
            "Bimpoagya",
            "Bukuruso",
            "Canaan",
            "Domama",
            "Domeabra",
            "Hemanso",
            "Kayireku A",
            "Kobekuro",
            "Kookoase",
            "Kwakyikrom",
            "Kyeaboso",
            "Kyerenkum",
            "Mmaabaasa",
            "Mmaampehia",
            "Nana Kwaku",
            "Nipabre",
            "Nsadweso",
            "Nuamahkrom",
            "Number 1",
            "Number 8",
            "Nyame Ndae",
            "Obrayeko",
            "Odumase",
            "Osenso",
            "Paulkrom",
            "Subriso",
            "Suhyen",
            "Tafrejoa",
            "Tulasikrom",
            "Tweapease",
            "Twifo Kubekor",
            "Wawase"
          ],
          "showOtherItem": true,
          "otherText": "Other (write)"
        },
        {
          "type": "text",
          "name": "orgquestion6",
          "title": "National Identification Number (Ghana Card No.)",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "orgquestion7",
          "title": "Farm Code ",
          "isRequired": true,
          "readOnly": true
        },
        {
          "type": "text",
          "name": "orgquestion8",
          "title": "Farm Size (In Hectares)",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "orgquestion9",
          "title": "Year of Establishment",
          "isRequired": true,
          "validators": [
            {
              "type": "numeric",
              "text": "Please enter a valid year between 1900 and 2024.",
              "minValue": 1900,
              "maxValue": 2024
            },
            {
              "type": "regex",
              "text": "Please enter a 4-digit year.",
              "regex": "^\\d{4}$"
            }
          ],
          "inputType": "number",
          "min": 1900,
          "max": 2024,
          "placeholder": "YYYY"
        },
        {
          "type": "text",
          "name": "orgquestion10",
          "title": "Number of Cocoa Trees",
          "inputType": "number"
        },
        {
          "type": "tagbox",
          "name": "orgquestion11",
          "title": "Other Crops Grown",
          "choices": [
            "Avocado",
            "Cassava",
            "Coconut",
            "Cocoyam",
            "Kola nut",
            "Mango",
            "Orange",
            "Oil palm",
            "Pineapple",
            "Yam"
          ],
          "showOtherItem": true,
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "orgquestion12",
          "title": "Is the Farm under Agroforestry?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "orgquestion13",
          "title": "Land Ownership",
          "isRequired": true,
          "choices": [
            "Owned",
            "Leased",
            "Family Land"
          ],
          "showOtherItem": true
        },
        {
          "type": "text",
          "name": "orgquestion14",
          "visibleIf": "{orgquestion13} = 'Leased'",
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
          "visibleIf": "{orgquestion16} = 'No'",
          "title": "If no, is the farm in the conversion period?",
          "requiredIf": "{orgquestion16} = 'No'",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "orgquestion18",
          "title": "When did you start organic farming?",
          "inputType": "date"
        },

        {
          "type": "tagbox",
          "name": "orgquestion19",
          "title": "Have you been using synthetic inputs in the last 3 years?",
          "choices": [
            "Acetestar",
            "Actara",
            "Akatemaster",
            "Confidor"
          ],
          "showOtherItem": true,
          "showNoneItem": true
        },
        {
          "type": "text",
          "name": "orgquestion20",
          "visibleIf": "{orgquestion19} = 'Yes'",
          "title": "If yes, give examples of Active Ingredients"
        },
        {
          "type": "tagbox",
          "name": "orgquestion21",
          "title": "Fertilizer Used (check all that apply)",
          "choices": [
            "Compost",
            "Manure",
            "Cover Crops"
          ],
          "showOtherItem": true,
          "showNoneItem": true
        },
        {
          "type": "tagbox",
          "name": "orgquestion22",
          "title": "Pest Control Methods (check all that apply)",
          "choices": [
            "Neem Oil",
            "Biological Control",
            "Manual Weeding"
          ],
          "showOtherItem": true,
          "showNoneItem": true
        },
        {
          "type": "tagbox",
          "name": "orgquestion23",
          "title": "Weed Management",
          "choices": [
            "Slasher",
            "Mulching",
            "Machete"
          ],
          "showOtherItem": true,
          "showNoneItem": true
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
          "visibleIf": "{orgquestion24} = 'Yes'",
          "title": "If yes, specify when you received training",
          "requiredIf": "{orgquestion24} = 'Yes'"
        },
        {
          "type": "text",
          "name": "orgquestion255",
          "visibleIf": "{orgquestion24} = 'Yes'",
          "title": "If yes, specify from whom did you received training",
          "requiredIf": "{orgquestion24} = 'Yes'"
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
          "visibleIf": "{orgquestion26} = 'Yes'",
          "title": "If yes, specify when you received technical support",
          "requiredIf": "{orgquestion26} = 'Yes'"
        },
        {
          "type": "text",
          "name": "orgquestion277",
          "visibleIf": "{orgquestion26} = 'Yes'",
          "title": "If yes, specify from whom did you received technical support",
          "requiredIf": "{orgquestion26} = 'Yes'"
        },
        {
          "type": "dropdown",
          "name": "orgquestion28",
          "title": "Are you willing to comply with organic certification standards?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "orgquestion29",
          "title": "Are you willing to undergo regular inspections?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "orgquestion30",
          "title": "Do you agree to maintain records of farm activities?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "orgquestion31",
          "title": "I ......., declare that the information provided in this form is accurate to the best of my knowledge.2. I commit to following organic farming practices and agree to be part of the internal control system (ICS) for organic certification.",
          "isRequired": true
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
        }
      ]
    }
  ]
}
