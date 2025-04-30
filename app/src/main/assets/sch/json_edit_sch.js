const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "dropdown",
          "name": "sch_name",
          "title": "Name of district.",
          "isRequired": true,
          "choices": [
            "Atronie",
            "Nsuatre",
            "Techiman"
          ]
        },
        {
          "type": "dropdown",
          "name": "sch_district",
          "title": " Select community",
          "isRequired": true,
          "choices": [
            "Akrofuom-A",
            "Akyenkyensua-B",
            "Antwi Krom",
            "Asamoah Krom",
            "Asuo-Agya-A",
            "Asuo-Agya-B",
            "Atronie Camp",
            "Atuahene-A",
            "Atuahene-B",
            "Aworowa-B",
            "Aworowa-C",
            "Aworowa-D",
            "Aworowa-E",
            "Ayimoh",
            "Bowohomoden",
            "Daadom",
            "Jinejine",
            "Kokrompe-A",
            "Kokrompe-B",
            "Kokrompe-C",
            "Kokrompe-D",
            "Krobo",
            "Kwabena-Kuma",
            "Kwaku-Badu Krom",
            "Maampehia",
            "Mesidan",
            "Mpatapo",
            "Nkran-Ketewa",
            "Nkran-Krom",
            "Nkwaeso-A",
            "Nsesreso",
            "Nsuatre",
            "Nsuatre-A",
            "Nsuatre-Adiepena",
            "Nsuatre-B",
            "Nsuta Ahenfie-A",
            "Nsuta Ahenfie-B",
            "Nsuta-A",
            "Nsuta-B",
            "Nsuta-Bonkwae",
            "Nwowasu-A",
            "Nwowasu-B",
            "Ohu Krom",
            "Ojugukrom",
            "Senase",
            "Srapukrom",
            "Tano-Anafo",
            "Tuobodom"
          ]
        },
        {
          "type": "text",
          "name": "sch_community",
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
          "type": "dropdown",
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
        }
      ]
    }
  ]
}