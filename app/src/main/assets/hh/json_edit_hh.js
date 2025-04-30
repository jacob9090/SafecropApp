const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "text",
          "name": "hh_name",
          "title": "Farmer ID",
          "readOnly": true
        },
        {
          "type": "text",
          "name": "hh_district",
          "title": "District",
          "readOnly": true
        },
        {
          "type": "text",
          "name": "hh_community",
          "title": "Community",
          "readOnly": true
        },
        {
          "type": "dropdown",
          "name": "hhquestion4",
          "title": "Is the head of the household a farm owner or a sharecropper?",
          "isRequired": true,
          "choices": [
            "Farm owner",
            "Sharecropper"
          ]
        },
        {
          "type": "text",
          "name": "hhquestion5",
          "title": "Total number of people living in this household",
          "inputType": "number",
          "max": 20,
          "maxErrorText": "The value should not be greater than {20}"
        },
        {
          "type": "dropdown",
          "name": "hhquestion6",
          "title": "How long has this household lived here?",
          "choices": [
            "less than 1 year",
            "1 - 3 years",
            "4 - 6 years",
            "7 - 10 years",
            "11 - 15 years",
            {
              "value": "more than 15 ",
              "text": "more than 15 years"
            }
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion7",
          "title": "Does head of this household hire the services of other workers?",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion8",
          "title": "Type of worker",
          "choices": [
            "Hired labor",
            "Share-cropper",
            "Family labor",
            "Communal labor"
          ]
        },
        {
          "type": "text",
          "name": "hhquestion9",
          "title": "Number of workers on your farm last season?",
          "inputType": "number",
          "max": 100,
          "maxErrorText": "The value should not be greater than {100}"
        },
        {
          "type": "dropdown",
          "name": "hhquestion10",
          "title": "On the average, how much did the farmer spend on the farm last year?",
          "choices": [
            "less than one third of the revenues of the sales of annual production",
            {
              "value": "equal to or more than one third of the revenues of the sales of annual production",
              "text": "equal to or more than one third of the revenues of the sales of annual production\""
            }
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion11",
          "title": "In what form are workers paid?",
          "choices": [
            "Sharing benefits when gains are made",
            "No remuneration",
            "Periodic salary in cash",
            "Periodic salary in kind",
            "Other (describe)"
          ]
        },
        {
          "type": "text",
          "name": "hhquestion12",
          "visibleIf": "{hhquestion11} = 'Other (describe)'",
          "title": " If other: Please specify the answer to the previous question.\n",
          "maxLength": 50
        },
        {
          "type": "dropdown",
          "name": "hhquestion13",
          "title": " What is the average worker wage per year?\n",
          "choices": [
            "1/2 of produce",
            "1/3 of produce",
            "1/4 of produce"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion14",
          "title": " What is the frequency of the workers\\' wages?\n",
          "choices": [
            "Irregular: workers are paid every time the farm sells cocoa to the LBC",
            "Daily",
            "Weekly",
            "Monthly",
            "Annually",
            "Yearly"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion15",
          "title": " Do workers have a workers contract with the farm? (either with the sharecropper of the farm owner)\n",
          "choices": [
            "yes, written",
            "yes, verbal with a witness",
            "yes, verbal without a witness",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion16",
          "title": "What is the main construction material used for the building wall? \n",
          "choices": [
            "Mud bricks. Earth, wood, bamboo, metal sheet/slate/asbestos, palm leaves/thatch (grass/raffia), or other",
            "Cement/concrete blocks, limecrete, stone, or burnt bricks\""
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion17",
          "title": "What type of toilet facility is usually used by the household?\n",
          "choices": [
            "toilet (e.g., KVIP, pit plan)",
            "No toilet facility (bush, beach), or other",
            "Pit latrine, bucket/pan",
            "KVIP, or W.C.\""
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion18",
          "title": "What is the main fuel used by the household for cooking? \n",
          "choices": [
            "Wood, crop residue, sawdust, animal waste, or other",
            "Charcoal, or Kerosene",
            "gas, or electricity\""
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion19",
          "title": "Does any household member own a working box iron or electric iron? \n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion20",
          "title": "Does any household member own a working television or radio set?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion21",
          "title": "Does any household member own a working mobile phone? \n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion22",
          "title": "Does any household member own a working bicycle, motor cycle, or car. \n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion23",
          "title": "What is the type of medical establishment usually used by this household?\n",
          "choices": [
            "rural health center",
            "general hospital",
            "traditional medicine center",
            "CHPS compound",
            {
              "value": "pharmacy shop/drug store",
              "text": "pharmacy shop/drug store\""
            }
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion24",
          "title": " What is the head of household\\'s educational level?\n",
          "choices": [
            "none",
            "primary",
            "JHS",
            "SHS",
            "Higher education (university level)\""
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion25",
          "title": "Can the head read a phrase/sentence in English? \n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion26",
          "title": "Has the head of the household or farm owner benefited from adult literacy training programs?\r\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion27",
          "title": "Has the head of the household or farm owner been trained on revenue and livelihood diversification?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion28",
          "title": "Has the head of the household or farm owner been trained in financial literacy?\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "hhquestion29",
          "title": "Does the head of the household or farm owner uses mobile banking services?\r\n",
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "hhquestion30",
          "visibleIf": "{hhquestion29} = 'Yes'",
          "title": "If Yes Provide Momo Number\r\n",
          "setValueExpression": "if {hhquestion30} < 10",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "hhquestion31",
          "title": "How many children between 5 – 17 years are in this household?\n",
          "inputType": "number",
          "min": 0
        },
        {
          "type": "text",
          "name": "hhquestion32",
          "title": "How many children between 5 – 17 years have birth certificates?\n",
          "inputType": "number"
        },
        {
          "type": "dropdown",
          "name": "hhquestion36",
          "title": "What other income generating activity do you have in addition to Cocoa",
          "choices": [
            "Farming",
            "Business",
            "Both Farming and Business",
            "Other",
            "None"
          ]
        },
        {
          "type": "text",
          "name": "hhquestion37",
          "title": "How much were you able to receive from the above activity in the past 12 months?",
          "inputType": "number"
        },
        {
          "type": "panel",
          "name": "location_panel",
          "elements": [
            {
              "type": "text",
              "name": "hh_location",
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