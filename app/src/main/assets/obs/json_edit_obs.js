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
          "title": "Gender of child\n",
          "isRequired": true,
          "choices": [
            {
              "value": "Item 1",
              "text": "Male"
            },
            {
              "value": "Item 2",
              "text": "Female"
            }
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
          "maxLength": 15
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
          "maxLength": 50
        },
        {
          "type": "text",
          "name": "obsquestion16",
          "title": "What are the problems the child faces out of school?\n",
          "maxLength": 50
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
          "maxLength": 50
        },
        {
          "type": "text",
          "name": "obsquestion19",
          "title": "Indirect actions aimed at improving the child's situation\n",
          "maxLength": 50
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
//          "name": "schquestion1",
//          "title": "Name of district.",
//          "isRequired": true,
//          "choices": [
//            "suhum",
//            "enchi"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "schquestion2",
//          "title": " Select community",
//          "isRequired": true,
//          "choices": [
//            "oda",
//            "sameraboi"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "schquestion3",
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
//          "type": "text",
//          "name": "question25",
//          "title": "Geo-Location",
//          "maxLength": 15
//        },
//        {
//          "type": "file",
//          "name": "question27",
//          "title": "Photo of school"
//        }
//      ]
//    }
//  ]
//}