const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "text",
          "name": "farmer_id",
          "title": "Farmer ID",
          "readOnly": true
        },
        {
          "type": "text",
          "name": "district",
          "title": "District",
          "readOnly": true
        },
        {
          "type": "text",
          "name": "community",
          "title": "Community",
          "readOnly": true
        },
        {
          "type": "dropdown",
          "name": "childquestion4",
          "title": "How many children between 5 to 17 years are in this household?",
          "isRequired": true,
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
          "type": "panel",
          "name": "childpanel1",
          "visibleIf": "{childquestion4} >= 1",
          "requiredIf": "{childquestion4} notempty",
          "elements": [
            {
              "type": "text",
              "name": "child1question1",
              "title": "(1.1)  Name of Child 1",
              "isRequired": true,
              "requiredIf": "{childquestion4} notempty",
              "maxLength": 50
            },
            {
              "type": "text",
              "name": "child1question2",
              "title": "(1.2)  Age of Child 1",
              "isRequired": true,
              "requiredIf": "{childquestion4} notempty",
              "inputType": "number",
              "min": 5,
              "max": 17,
              "minErrorText": "The value should not be less than {5}",
              "maxErrorText": "The value should not be greater than {17}"
            },
            {
              "type": "dropdown",
              "name": "child1question3",
              "title": "(1.3)  Gender of Child 1",
              "isRequired": true,
              "requiredIf": "{childquestion4} notempty",
              "choices": [
                "Male",
                "Female"
              ]
            },
            {
              "type": "dropdown",
              "name": "child1question4",
              "title": "(1.4)  Who does child 1 live with?",
              "isRequired": true,
              "requiredIf": "{childquestion4} notempty",
              "choices": [
                "Both Parent",
                "Only Mother",
                "Only Father",
                "Grandparent",
                "Family Member",
                "Guardian",
                "Friend"
              ]
            },
            {
              "type": "dropdown",
              "name": "child1question5",
              "title": "(1.5)  Can child 1 read or write in English?",
              "isRequired": true,
              "requiredIf": "{childquestion4} notempty",
              "choices": [
                "Yes",
                "No"
              ]
            },
            {
              "type": "dropdown",
              "name": "child1question6",
              "title": "(1.6)  Does child 1 go to school?",
              "isRequired": true,
              "requiredIf": "{childquestion4} notempty",
              "choices": [
                "Yes: Currently in School",
                "No: Stop School",
                "No: Never been to School"
              ]
            },
            {
              "type": "text",
              "name": "child1question7",
              "visibleIf": "{child1question6} = 'Yes: Currently in School'",
              "title": "(1.7)  At what age did child 1 start school?",
              "isRequired": true,
              "requiredIf": "{child1question6} = 'Yes: Currently in School'",
              "inputType": "number",
              "min": 1,
              "max": 17
            },
            {
              "type": "text",
              "name": "child1question8",
              "visibleIf": "{child1question6} = 'Yes: Currently in School'",
              "title": "(1.8)  What is the name of child 1 school?",
              "isRequired": true,
              "requiredIf": "{child1question6} = 'Yes: Currently in School'",
              "maxLength": 50
            },
            {
              "type": "dropdown",
              "name": "child1question9",
              "visibleIf": "{child1question6} = 'Yes: Currently in School'",
              "title": "(1.9)  What is child 1 current educational level?",
              "isRequired": true,
              "requiredIf": "{child1question6} = 'Yes: Currently in School'",
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child1question10",
              "visibleIf": "{child1question6} = 'No: Stop School'",
              "title": "(1.10)  At what level/age did child 1 stop school?\n",
              "isRequired": true,
              "requiredIf": "{child1question6} = 'No: Stop School'",
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child1question11",
              "visibleIf": "{child1question6} = 'No: Stop School'",
              "title": "(1.11)  What are the reasons for absence of schooling?",
              "isRequired": true,
              "requiredIf": "{child1question6} = 'No: Stop School'",
              "choices": [
                "Personal Refusal",
                "Care for sick family Members",
                "Parents can't afford",
                "Lack of school items",
                "Learning to work",
                "Bad grades",
                "Fear of Punishment",
                "Deceased Parent",
                "No School Near"
              ],
              "showOtherItem": true
            },
            {
              "type": "dropdown",
              "name": "child1question12",
              "title": "(1.12)  Did child 1 work in the previous year?",
              "isRequired": true,
              "requiredIf": "{childquestion4} notempty",
              "choices": [
                "Yes: in his/her field",
                "Yes: in his/her family field",
                "Yes: On the farm of someone else",
                "No: does not work"
              ]
            },
            {
              "type": "tagbox",
              "name": "child1question13",
              "visibleIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(1.13)  What are the types of work did child 1 performed on the farm?",
              "isRequired": true,
              "requiredIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "choices": [
                "Gathering harvested cocoa with permissible weight",
                "Collecting Firewood",
                "Clearing of forest",
                "Felling of trees",
                "Bush burning",
                "Working with Agrochemicals i.e. Purchasing",
                "Assisting with Farm Chores",
                "Working in the farm during pesticide spraying",
                "Re-enter a sprayed farm in less than 12 hours",
                "Using machetes/long cutlass for weeding",
                "Climbing trees higher to cut mistletoe with cutlass",
                "Working with motorized mist blower, knapsack sprayer, and chainsaw",
                "Harvesting overhead cocoa with a sharp hook",
                "Breaking cocoa pods with breaking knife",
                "Carrying heavy load beyond permissible weight",
                "Working on the farm for more than 3 hours per day",
                "Working more than 2 hours/day on a school day",
                "Working without adequate protective clothing",
                "Working alone on the farm in isolation",
                "Working on farm between 6.00 p.m. and 5.30 a.m",
                "Withdrawn from school during cocoa season to do farm work",
                "Working full time on farm and not attending school"
              ]
            },
            {
              "type": "dropdown",
              "name": "child1question14",
              "visibleIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(1.14)  Daily working hours on a school day",
              "isRequired": true,
              "requiredIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "choices": [
                "Does not work on school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child1question15",
              "visibleIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(1.15)  Period of work",
              "requiredIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child1question16",
              "visibleIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(1.16)  Daily working hours on a non-school day",
              "requiredIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "choices": [
                "Does not work on non school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child1question17",
              "visibleIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(1.17)  Period of work ",
              "requiredIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child1question18",
              "visibleIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(1.18)  Why is child 1 working?",
              "requiredIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "choices": [
                "Skills development",
                "Supplemental income",
                "Family tradition or rural lifestyle",
                "Seasonal farming",
                "Migration and displacement",
                "Assisting aging parent or family members"
              ]
            },
            {
              "type": "dropdown",
              "name": "child1question19",
              "visibleIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(1.19)  For whom does child 1 work?",
              "requiredIf": "{child1question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "choices": [
                "Grandparent",
                "Parent",
                "Guardian",
                "Family Member",
                "Personal",
                "Friend",
                "Neighbor"
              ]
            }
          ]
        },
        {
          "type": "panel",
          "name": "childpanel2",
          "visibleIf": "{childquestion4} >= 2",
          "requiredIf": "{childquestion4} > 1",
          "elements": [
            {
              "type": "text",
              "name": "child2question1",
              "title": "(2.1)  Name of Child 2",
              "maxLength": 50
            },
            {
              "type": "text",
              "name": "child2question2",
              "title": "(2.2)  Age of Child 2",
              "inputType": "number",
              "min": 5,
              "max": 17,
              "minErrorText": "The value should not be less than {4}",
              "maxErrorText": "The value should not be greater than {18}"
            },
            {
              "type": "dropdown",
              "name": "child2question3",
              "title": "(2.3)  Gender of Child 2",
              "choices": [
                "Male",
                "Female"
              ]
            },
            {
              "type": "dropdown",
              "name": "child2question4",
              "title": "(2.4)  Who does child 2 live with?",
              "choices": [
                "Both Parent",
                "Only Mother",
                "Only Father",
                "Grandparent",
                "Family Member",
                "Guardian",
                "Friend"
              ]
            },
            {
              "type": "dropdown",
              "name": "child2question5",
              "title": "(2.5)  Can child 2 read or write in English?",
              "choices": [
                "Yes",
                "No"
              ]
            },
            {
              "type": "dropdown",
              "name": "child2question6",
              "title": "(2.6)  Does child 2 go to school?",
              "choices": [
                "Yes: Currently in School",
                "No: Stop School",
                "No: Never been to School"
              ]
            },
            {
              "type": "text",
              "name": "child2question7",
              "visibleIf": "{child2question6} = 'Yes: Currently in School'",
              "title": "(2.7)  At what age did child 2 start school?",
              "inputType": "number",
              "min": 1,
              "max": 17
            },
            {
              "type": "text",
              "name": "child2question8",
              "visibleIf": "{child2question6} = 'Yes: Currently in School'",
              "title": "(2.8)  What is the name of child 2 school?",
              "maxLength": 50
            },
            {
              "type": "dropdown",
              "name": "child2question9",
              "visibleIf": "{child2question6} = 'Yes: Currently in School'",
              "title": "(2.9)  What is child 2 current educational level?",
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child2question10",
              "visibleIf": "{child2question6} = 'No: Stop School'",
              "title": "(2.10)  At what level/age did child 2 stop school?",
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child2question11",
              "visibleIf": "{child2question6} = 'No: Stop School'",
              "title": "(2.11)  What are the reasons for absence of schooling?",
              "choices": [
                "Personal Refusal",
                "Care for sick family Members",
                "Parents can't afford",
                "Lack of school items",
                "Learning to work",
                "Bad grades",
                "Fear of Punishment",
                "Deceased Parent",
                "No School Near"
              ],
              "showOtherItem": true
            },
            {
              "type": "dropdown",
              "name": "child2question12",
              "title": "(2.12)  Did child 2 work in the previous year?",
              "choices": [
                "Yes: in his/her field",
                "Yes: in his/her family field",
                "Yes: On the farm of someone else",
                "No: does not work"
              ]
            },
            {
              "type": "tagbox",
              "name": "child2question13",
              "visibleIf": "{child2question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(2.13)  What are the types of work did child 2 performed on the farm?",
              "choices": [
                "Gathering harvested cocoa with permissible weight",
                "Collecting Firewood",
                "Clearing of forest",
                "Felling of trees",
                "Bush burning",
                "Working with Agrochemicals i.e. Purchasing",
                "Assisting with Farm Chores",
                "Working in the farm during pesticide spraying",
                "Re-enter a sprayed farm in less than 12 hours",
                "Using machetes/long cutlass for weeding",
                "Climbing trees higher to cut mistletoe with cutlass",
                "Working with motorized mist blower, knapsack sprayer, and chainsaw",
                "Harvesting overhead cocoa with a sharp hook",
                "Breaking cocoa pods with breaking knife",
                "Carrying heavy load beyond permissible weight",
                "Working on the farm for more than 3 hours per day",
                "Working more than 2 hours/day on a school day",
                "Working without adequate protective clothing",
                "Working alone on the farm in isolation",
                "Working on farm between 6.00 p.m. and 5.30 a.m",
                "Withdrawn from school during cocoa season to do farm work",
                "Working full time on farm and not attending school"
              ]
            },
            {
              "type": "dropdown",
              "name": "child2question14",
              "visibleIf": "{child2question12} anyof ['Yes: On the farm of someone else', 'Yes: in his/her family field', 'Yes: in his/her field']",
              "title": "(2.14)  Daily working hours on a school day",
              "choices": [
                "Does not work on school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child2question15",
              "visibleIf": "{child2question12} anyof ['Yes: On the farm of someone else', 'Yes: in his/her family field', 'Yes: in his/her field']",
              "title": "(2.15)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child2question16",
              "visibleIf": "{child2question12} anyof ['Yes: On the farm of someone else', 'Yes: in his/her family field', 'Yes: in his/her field']",
              "title": "(2.16)  Daily working hours on a non-school day",
              "choices": [
                "Does not work on non school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child2question17",
              "visibleIf": "{child2question12} anyof ['Yes: On the farm of someone else', 'Yes: in his/her family field', 'Yes: in his/her field']",
              "title": "(2.17)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child2question18",
              "visibleIf": "{child2question12} anyof ['Yes: On the farm of someone else', 'Yes: in his/her family field', 'Yes: in his/her field']",
              "title": "(2.18)  Why is child 2 working?",
              "choices": [
                "Skills development",
                "Supplemental income",
                "Family tradition or rural lifestyle",
                "Seasonal farming",
                "Migration and displacement",
                "Assisting aging parent or family members"
              ]
            },
            {
              "type": "dropdown",
              "name": "child2question19",
              "visibleIf": "{child2question12} anyof ['Yes: On the farm of someone else', 'Yes: in his/her family field', 'Yes: in his/her field']",
              "title": "(2.19)  For whom does child 2 work?",
              "choices": [
                "Grandparent",
                "Parent",
                "Guardian",
                "Family Member",
                "Personal",
                "Friend",
                "Neighbor"
              ]
            }
          ]
        },
        {
          "type": "panel",
          "name": "childpanel3",
          "visibleIf": "{childquestion4} >= 3",
          "requiredIf": "{childquestion4} > 2",
          "elements": [
            {
              "type": "text",
              "name": "child3question1",
              "title": "(3.1)  Name of Child 3",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "text",
              "name": "child3question2",
              "title": "(3.2)  Age of Child 3",
              "isRequired": true,
              "inputType": "number",
              "min": 5,
              "max": 17,
              "minErrorText": "The value should not be less than {4}",
              "maxErrorText": "The value should not be greater than {18}"
            },
            {
              "type": "dropdown",
              "name": "child3question3",
              "title": "(3.3)  Gender of Child 3",
              "isRequired": true,
              "choices": [
                "Male",
                "Female"
              ]
            },
            {
              "type": "dropdown",
              "name": "child3question4",
              "title": "(3.4)  Who does child 3 live with?",
              "choices": [
                "Both Parent",
                "Only Mother",
                "Only Father",
                "Grandparent",
                "Family Member",
                "Guardian",
                "Friend"
              ]
            },
            {
              "type": "dropdown",
              "name": "child3question5",
              "title": "(3.5)  Can child 3 read or write in English?",
              "isRequired": true,
              "choices": [
                "Yes",
                "No"
              ]
            },
            {
              "type": "dropdown",
              "name": "child3question6",
              "title": "(3.6)  Does child 3 go to school?",
              "isRequired": true,
              "choices": [
                "Yes: Currently in School",
                "No: Stop School",
                "No: Never been to School"
              ]
            },
            {
              "type": "text",
              "name": "child3question7",
              "visibleIf": "{child3question6} = 'Yes: Currently in School'",
              "title": "(3.7)  At what age did child 3 start school?",
              "isRequired": true,
              "inputType": "number",
              "min": 1,
              "max": 17
            },
            {
              "type": "text",
              "name": "child3question8",
              "visibleIf": "{child3question6} = 'Yes: Currently in School'",
              "title": "(3.8)  What is the name of child 3 school?",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "dropdown",
              "name": "child3question9",
              "visibleIf": "{child3question6} = 'Yes: Currently in School'",
              "title": "(3.9)  What is child 3 current educational level?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child3question10",
              "visibleIf": "{child3question6} = 'No: Stop School'",
              "title": "(3.10)  At what level/age did child 3 stop school?",
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child3question11",
              "visibleIf": "{child3question6} = 'No: Stop School'",
              "title": "(3.11)  What are the reasons for absence of schooling?",
              "choices": [
                "Personal Refusal",
                "Care for sick family Members",
                "Parents can't afford",
                "Lack of school items",
                "Learning to work",
                "Bad grades",
                "Fear of Punishment",
                "Deceased Parent",
                "No School Near"
              ],
              "showOtherItem": true
            },
            {
              "type": "dropdown",
              "name": "child3question12",
              "title": "(3.12)  Did child 3 work in the previous year?",
              "choices": [
                "Yes: in his/her field",
                "Yes: in his/her family field",
                "Yes: On the farm of someone else",
                "No: does not work"
              ]
            },
            {
              "type": "tagbox",
              "name": "child3question13",
              "visibleIf": "{child3question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(3.13)  What are the types of work did child 3 performed on the farm?",
              "choices": [
                "Gathering harvested cocoa with permissible weight",
                "Collecting Firewood",
                "Clearing of forest",
                "Felling of trees",
                "Bush burning",
                "Working with Agrochemicals i.e. Purchasing",
                "Assisting with Farm Chores",
                "Working in the farm during pesticide spraying",
                "Re-enter a sprayed farm in less than 12 hours",
                "Using machetes/long cutlass for weeding",
                "Climbing trees higher to cut mistletoe with cutlass",
                "Working with motorized mist blower, knapsack sprayer, and chainsaw",
                "Harvesting overhead cocoa with a sharp hook",
                "Breaking cocoa pods with breaking knife",
                "Carrying heavy load beyond permissible weight",
                "Working on the farm for more than 3 hours per day",
                "Working more than 2 hours/day on a school day",
                "Working without adequate protective clothing",
                "Working alone on the farm in isolation",
                "Working on farm between 6.00 p.m. and 5.30 a.m",
                "Withdrawn from school during cocoa season to do farm work",
                "Working full time on farm and not attending school"
              ]
            },
            {
              "type": "dropdown",
              "name": "child3question14",
              "visibleIf": "{child3question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(3.14)  Daily working hours on a school day",
              "choices": [
                "Does not work on school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child3question15",
              "visibleIf": "{child3question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(3.15)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening "
              ]
            },
            {
              "type": "dropdown",
              "name": "child3question16",
              "visibleIf": "{child3question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(3.16)  Daily working hours on a non-school day",
              "choices": [
                "Does not work on non school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child3question17",
              "visibleIf": "{child3question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(3.17)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child3question18",
              "visibleIf": "{child3question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(3.18)  Why is child 3 working?",
              "choices": [
                "Skills development",
                "Supplemental income",
                "Family tradition or rural lifestyle",
                "Seasonal farming",
                "Migration and displacement",
                "Assisting aging parent or family members"
              ]
            },
            {
              "type": "dropdown",
              "name": "child3question19",
              "visibleIf": "{child3question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(3.19)  For whom does child 3 work?",
              "choices": [
                "Grandparent",
                "Parent",
                "Guardian",
                "Family Member",
                "Personal",
                "Friend",
                "Neighbor"
              ]
            }
          ]
        },
        {
          "type": "panel",
          "name": "childpanel4",
          "visibleIf": "{childquestion4} >= 4",
          "requiredIf": "{childquestion4} > 3",
          "elements": [
            {
              "type": "text",
              "name": "child4question1",
              "title": "(4.1)  Name of Child 4",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "text",
              "name": "child4question2",
              "title": "(4.2)  Age of Child 4",
              "isRequired": true,
              "inputType": "number",
              "min": 5,
              "max": 17,
              "minErrorText": "The value should not be less than {4}",
              "maxErrorText": "The value should not be greater than {18}"
            },
            {
              "type": "dropdown",
              "name": "child4question3",
              "title": "(4.3)  Gender of Child 4",
              "isRequired": true,
              "choices": [
                "Male",
                "Female"
              ]
            },
            {
              "type": "dropdown",
              "name": "child4question4",
              "title": "(4.4)  Who does child 4 live with?",
              "isRequired": true,
              "choices": [
                "Both Parent",
                "Only Mother",
                "Only Father",
                "Grandparent",
                "Family Member",
                "Guardian",
                "Friend"
              ]
            },
            {
              "type": "dropdown",
              "name": "child4question5",
              "title": "(4.5)  Can child 4 read or write in English?",
              "isRequired": true,
              "choices": [
                "Yes",
                "No"
              ]
            },
            {
              "type": "dropdown",
              "name": "child4question6",
              "title": "(4.6)  Does child 4 go to school?",
              "isRequired": true,
              "choices": [
                "Yes: Currently in School",
                "No: Stop School",
                "No: Never been to School"
              ]
            },
            {
              "type": "text",
              "name": "child4question7",
              "visibleIf": "{child4question6} = 'Yes: Currently in School'",
              "title": "(4.7)  At what age did child 4 start school?",
              "isRequired": true,
              "inputType": "number",
              "min": 1,
              "max": 17
            },
            {
              "type": "text",
              "name": "child4question8",
              "visibleIf": "{child4question6} = 'Yes: Currently in School'",
              "title": "(4.8)  What is the name of child 4 school?",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "dropdown",
              "name": "child4question9",
              "visibleIf": "{child4question6} = 'Yes: Currently in School'",
              "title": "(4.9)  What is child 4 current educational level?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child4question10",
              "visibleIf": "{child4question6} = 'No: Stop School'",
              "title": "(4.10)  At what level/age did child 4 stop school?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child4question11",
              "visibleIf": "{child4question6} = 'No: Stop School'",
              "title": "(4.11)  What are the reasons for absence of schooling?",
              "choices": [
                "Personal Refusal",
                "Care for sick family Members",
                "Parents can't afford",
                "Lack of school items",
                "Learning to work",
                "Bad grades",
                "Fear of Punishment",
                "Deceased Parent",
                "No School Near"
              ],
              "showOtherItem": true
            },
            {
              "type": "dropdown",
              "name": "child4question12",
              "title": "(4.12)  Did child 4 work in the previous year?",
              "isRequired": true,
              "choices": [
                "Yes: in his/her field",
                "Yes: in his/her family field",
                "Yes: On the farm of someone else",
                "No: does not work"
              ]
            },
            {
              "type": "tagbox",
              "name": "child4question13",
              "visibleIf": "{child4question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(4.13)  What are the types of work did child 4 performed on the farm?",
              "choices": [
                "Gathering harvested cocoa with permissible weight",
                "Collecting Firewood",
                "Clearing of forest",
                "Felling of trees",
                "Bush burning",
                "Working with Agrochemicals i.e. Purchasing",
                "Assisting with Farm Chores",
                "Working in the farm during pesticide spraying",
                "Re-enter a sprayed farm in less than 12 hours",
                "Using machetes/long cutlass for weeding",
                "Climbing trees higher to cut mistletoe with cutlass",
                "Working with motorized mist blower, knapsack sprayer, and chainsaw",
                "Harvesting overhead cocoa with a sharp hook",
                "Breaking cocoa pods with breaking knife",
                "Carrying heavy load beyond permissible weight",
                "Working on the farm for more than 3 hours per day",
                "Working more than 2 hours/day on a school day",
                "Working without adequate protective clothing",
                "Working alone on the farm in isolation",
                "Working on farm between 6.00 p.m. and 5.30 a.m",
                "Withdrawn from school during cocoa season to do farm work",
                "Working full time on farm and not attending school"
              ]
            },
            {
              "type": "dropdown",
              "name": "child4question14",
              "visibleIf": "{child4question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(4.14)  Daily working hours on a school day",
              "choices": [
                "Does not work on school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child4question15",
              "visibleIf": "{child4question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(4.15)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child4question16",
              "visibleIf": "{child4question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(4.16)  Daily working hours on a non-school day",
              "choices": [
                "Does not work on non school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child4question17",
              "visibleIf": "{child4question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(4.17)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child4question18",
              "visibleIf": "{child4question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(4.18)  Why is child 4 working?",
              "choices": [
                "Skills development",
                "Supplemental income",
                "Family tradition or rural lifestyle",
                "Seasonal farming",
                "Migration and displacement",
                "Assisting aging parent or family members"
              ]
            },
            {
              "type": "dropdown",
              "name": "child4question19",
              "visibleIf": "{child4question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(4.19)  For whom does child 4 work?",
              "choices": [
                "Grandparent",
                "Parent",
                "Guardian",
                "Family Member",
                "Personal",
                "Friend",
                "Neighbor"
              ]
            }
          ]
        },
        {
          "type": "panel",
          "name": "childpanel5",
          "visibleIf": "{childquestion4} >= 5",
          "requiredIf": "{childquestion4} > 4",
          "elements": [
            {
              "type": "text",
              "name": "child5question1",
              "title": "(5.1)  Name of Child 5",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "text",
              "name": "child5question2",
              "title": "(5.2)  Age of Child 5",
              "isRequired": true,
              "inputType": "number",
              "min": 5,
              "max": 17,
              "minErrorText": "The value should not be less than {4}",
              "maxErrorText": "The value should not be greater than {18}"
            },
            {
              "type": "dropdown",
              "name": "child5question3",
              "title": "(5.3)  Gender of Child 5",
              "isRequired": true,
              "choices": [
                "Male",
                "Female"
              ]
            },
            {
              "type": "dropdown",
              "name": "child5question4",
              "title": "(5.4)  Who does child 5 live with?",
              "isRequired": true,
              "choices": [
                "Both Parent",
                "Only Mother",
                "Only Father",
                "Grandparent",
                "Family Member",
                "Guardian",
                "Friend"
              ]
            },
            {
              "type": "dropdown",
              "name": "child5question5",
              "title": "(5.5)  Can child 5 read or write in English?",
              "isRequired": true,
              "choices": [
                "Yes",
                "No"
              ]
            },
            {
              "type": "dropdown",
              "name": "child5question6",
              "title": "(5.6)  Does child 5 go to school?",
              "isRequired": true,
              "choices": [
                "Yes: Currently in School",
                "No: Stop School",
                "No: Never been to School"
              ]
            },
            {
              "type": "text",
              "name": "child5question7",
              "visibleIf": "{child5question6} = 'Yes: Currently in School'",
              "title": "(5.7)  At what age did child 5 start school?",
              "isRequired": true,
              "inputType": "number",
              "min": 1,
              "max": 17
            },
            {
              "type": "text",
              "name": "child5question8",
              "visibleIf": "{child5question6} = 'Yes: Currently in School'",
              "title": "(5.8)  What is the name of child 5 school?",
              "maxLength": 50
            },
            {
              "type": "dropdown",
              "name": "child5question9",
              "visibleIf": "{child5question6} = 'Yes: Currently in School'",
              "title": "(5.9)  What is child 5 current educational level?",
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child5question10",
              "visibleIf": "{child5question6} = 'No: Stop School'",
              "title": "(5.10)  At what level/age did child 5 stop school?",
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child5question11",
              "visibleIf": "{child5question6} = 'No: Stop School'",
              "title": "(5.11)  What are the reasons for absence of schooling?",
              "choices": [
                "Personal Refusal",
                "Care for sick family Members",
                "Parents can't afford",
                "Lack of school items",
                "Learning to work",
                "Bad grades",
                "Fear of Punishment",
                "Deceased Parent",
                "No School Near"
              ],
              "showOtherItem": true
            },
            {
              "type": "dropdown",
              "name": "child5question12",
              "title": "(5.12)  Did child 5 work in the previous year?",
              "isRequired": true,
              "choices": [
                "Yes: in his/her field",
                "Yes: in his/her family field",
                "Yes: On the farm of someone else",
                "No: does not work"
              ]
            },
            {
              "type": "tagbox",
              "name": "child5question13",
              "visibleIf": "{child5question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(5.13)  What are the types of work did child 5 performed on the farm?",
              "choices": [
                "Gathering harvested cocoa with permissible weight",
                "Collecting Firewood",
                "Clearing of forest",
                "Felling of trees",
                "Bush burning",
                "Working with Agrochemicals i.e. Purchasing",
                "Assisting with Farm Chores",
                "Working in the farm during pesticide spraying",
                "Re-enter a sprayed farm in less than 12 hours",
                "Using machetes/long cutlass for weeding",
                "Climbing trees higher to cut mistletoe with cutlass",
                "Working with motorized mist blower, knapsack sprayer, and chainsaw",
                "Harvesting overhead cocoa with a sharp hook",
                "Breaking cocoa pods with breaking knife",
                "Carrying heavy load beyond permissible weight",
                "Working on the farm for more than 3 hours per day",
                "Working more than 2 hours/day on a school day",
                "Working without adequate protective clothing",
                "Working alone on the farm in isolation",
                "Working on farm between 6.00 p.m. and 5.30 a.m",
                "Withdrawn from school during cocoa season to do farm work",
                "Working full time on farm and not attending school"
              ]
            },
            {
              "type": "dropdown",
              "name": "child5question14",
              "visibleIf": "{child5question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(5.14)  Daily working hours on a school day",
              "choices": [
                "Does not work on school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child5question15",
              "visibleIf": "{child5question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(5.15)  Period of work",
              "isRequired": true,
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child5question16",
              "visibleIf": "{child5question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(5.16)  Daily working hours on a non-school day",
              "isRequired": true,
              "choices": [
                "Does not work on non school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child5question17",
              "visibleIf": "{child5question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(5.17)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child5question18",
              "visibleIf": "{child5question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(5.18)  Why is child 5 working?",
              "choices": [
                "Skills development",
                "Supplemental income",
                "Family tradition or rural lifestyle",
                "Seasonal farming",
                "Migration and displacement",
                "Assisting aging parent or family members"
              ]
            },
            {
              "type": "dropdown",
              "name": "child5question19",
              "visibleIf": "{child5question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(5.19)  For whom does child 5 work?",
              "choices": [
                "Grandparent",
                "Parent",
                "Guardian",
                "Family Member",
                "Personal",
                "Friend",
                "Neighbor"
              ]
            }
          ]
        },
        {
          "type": "panel",
          "name": "childpanel6",
          "visibleIf": "{childquestion4} >= 6",
          "requiredIf": "{childquestion4} > 5",
          "elements": [
            {
              "type": "text",
              "name": "child6question1",
              "title": "(6.1)  Name of Child 6",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "text",
              "name": "child6question2",
              "title": "(6.2)  Age of Child 6",
              "isRequired": true,
              "inputType": "number",
              "min": 5,
              "max": 17,
              "minErrorText": "The value should not be less than {4}",
              "maxErrorText": "The value should not be greater than {18}"
            },
            {
              "type": "dropdown",
              "name": "child6question3",
              "title": "(6.3)  Gender of Child 6",
              "isRequired": true,
              "choices": [
                "Male",
                "Female"
              ]
            },
            {
              "type": "dropdown",
              "name": "child6question4",
              "title": "(6.4)  Who does child 6 live with?",
              "isRequired": true,
              "choices": [
                "Both Parent",
                "Only Mother",
                "Only Father",
                "Grandparent",
                "Family Member",
                "Guardian",
                "Friend"
              ]
            },
            {
              "type": "dropdown",
              "name": "child6question5",
              "title": "(6.5)  Can child 6 read or write in English?",
              "isRequired": true,
              "choices": [
                "Yes",
                "No"
              ]
            },
            {
              "type": "dropdown",
              "name": "child6question6",
              "title": "(6.6)  Does child 6 go to school?",
              "isRequired": true,
              "choices": [
                "Yes: Currently in School",
                "No: Stop School",
                "No: Never been to School"
              ]
            },
            {
              "type": "text",
              "name": "child6question7",
              "visibleIf": "{child6question6} = 'Yes: Currently in School'",
              "title": "(6.7)  At what age did child 6 start school?",
              "isRequired": true,
              "inputType": "number",
              "min": 1,
              "max": 17
            },
            {
              "type": "text",
              "name": "child6question8",
              "visibleIf": "{child6question6} = 'Yes: Currently in School'",
              "title": "(6.8)  What is the name of child 6 school?",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "dropdown",
              "name": "child6question9",
              "visibleIf": "{child6question6} = 'Yes: Currently in School'",
              "title": "(6.9)  What is child 6 current educational level?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child6question10",
              "visibleIf": "{child6question6} = 'No: Stop School'",
              "title": "(6.10)  At what level/age did child 6 stop school?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child6question11",
              "visibleIf": "{child6question6} = 'No: Stop School'",
              "title": "(6.11)  What are the reasons for absence of schooling?",
              "choices": [
                "Personal Refusal",
                "Care for sick family Members",
                "Parents can't afford",
                "Lack of school items",
                "Learning to work",
                "Bad grades",
                "Fear of Punishment",
                "Deceased Parent",
                "No School Near"
              ],
              "showOtherItem": true
            },
            {
              "type": "dropdown",
              "name": "child6question12",
              "title": "(6.12)  Did child 6 work in the previous year?",
              "isRequired": true,
              "choices": [
                "Yes: in his/her field",
                "Yes: in his/her family field",
                "Yes: On the farm of someone else",
                "No: does not work"
              ]
            },
            {
              "type": "tagbox",
              "name": "child6question13",
              "visibleIf": "{child6question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(6.13)  What are the types of work did child 6 performed on the farm?",
              "choices": [
                "Gathering harvested cocoa with permissible weight",
                "Collecting Firewood",
                "Clearing of forest",
                "Felling of trees",
                "Bush burning",
                "Working with Agrochemicals i.e. Purchasing",
                "Assisting with Farm Chores",
                "Working in the farm during pesticide spraying",
                "Re-enter a sprayed farm in less than 12 hours",
                "Using machetes/long cutlass for weeding",
                "Climbing trees higher to cut mistletoe with cutlass",
                "Working with motorized mist blower, knapsack sprayer, and chainsaw",
                "Harvesting overhead cocoa with a sharp hook",
                "Breaking cocoa pods with breaking knife",
                "Carrying heavy load beyond permissible weight",
                "Working on the farm for more than 3 hours per day",
                "Working more than 2 hours/day on a school day",
                "Working without adequate protective clothing",
                "Working alone on the farm in isolation",
                "Working on farm between 6.00 p.m. and 5.30 a.m",
                "Withdrawn from school during cocoa season to do farm work",
                "Working full time on farm and not attending school"
              ]
            },
            {
              "type": "dropdown",
              "name": "child6question14",
              "visibleIf": "{child6question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(6.14)  Daily working hours on a school day",
              "choices": [
                "Does not work on school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child6question15",
              "visibleIf": "{child6question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(6.15)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child6question16",
              "visibleIf": "{child6question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(6.16)  Daily working hours on a non-school day",
              "choices": [
                "Does not work on non school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child6question17",
              "visibleIf": "{child6question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(6.17)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child6question18",
              "visibleIf": "{child6question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(6.18)  Why is child 6 working?",
              "choices": [
                "Skills development",
                "Supplemental income",
                "Family tradition or rural lifestyle",
                "Seasonal farming",
                "Migration and displacement",
                "Assisting aging parent or family members"
              ]
            },
            {
              "type": "dropdown",
              "name": "child6question19",
              "visibleIf": "{child6question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(6.19)  For whom does child 6 work?",
              "choices": [
                "Grandparent",
                "Parent",
                "Guardian",
                "Family Member",
                "Personal",
                "Friend",
                "Neighbor"
              ]
            }
          ]
        },
        {
          "type": "panel",
          "name": "childpanel7",
          "visibleIf": "{childquestion4} >= 7",
          "requiredIf": "{childquestion4} > 6",
          "elements": [
            {
              "type": "text",
              "name": "child7question1",
              "title": "(7.1)  Name of Child 7",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "text",
              "name": "child7question2",
              "title": "(7.2)  Age of Child 7",
              "isRequired": true,
              "inputType": "number",
              "min": 5,
              "max": 17,
              "minErrorText": "The value should not be less than {4}",
              "maxErrorText": "The value should not be greater than {18}"
            },
            {
              "type": "dropdown",
              "name": "child7question3",
              "title": "(7.3)  Gender of Child 7",
              "isRequired": true,
              "choices": [
                "Male",
                "Female"
              ]
            },
            {
              "type": "dropdown",
              "name": "child7question4",
              "title": "(7.4)  Who does child 7 live with?",
              "isRequired": true,
              "choices": [
                "Both Parent",
                "Only Mother",
                "Only Father",
                "Grandparent",
                "Family Member",
                "Guardian",
                "Friend"
              ]
            },
            {
              "type": "dropdown",
              "name": "child7question5",
              "title": "(7.5)  Can child 7 read or write in English?",
              "isRequired": true,
              "choices": [
                "Yes",
                "No"
              ]
            },
            {
              "type": "dropdown",
              "name": "child7question6",
              "title": "(7.6)  Does child 7 go to school?",
              "isRequired": true,
              "choices": [
                "Yes: Currently in School",
                "No: Stop School",
                "No: Never been to School"
              ]
            },
            {
              "type": "text",
              "name": "child7question7",
              "visibleIf": "{child7question6} = 'Yes: Currently in School'",
              "title": "(7.7)  At what age did child 7 start school?",
              "isRequired": true,
              "inputType": "number",
              "min": 1,
              "max": 17
            },
            {
              "type": "text",
              "name": "child7question8",
              "visibleIf": "{child7question6} = 'Yes: Currently in School'",
              "title": "(7.8)  What is the name of child 7 school?",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "dropdown",
              "name": "child7question9",
              "visibleIf": "{child7question6} = 'Yes: Currently in School'",
              "title": "(7.9)  What is child 7 current educational level?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child7question10",
              "visibleIf": "{child7question6} = 'No: Stop School'",
              "title": "(7.10)  At what level/age did child 7 stop school?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child7question11",
              "visibleIf": "{child7question6} = 'No: Stop School'",
              "title": "(7.11)  What are the reasons for absence of schooling?",
              "choices": [
                "Personal Refusal",
                "Care for sick family Members",
                "Parents can't afford",
                "Lack of school items",
                "Learning to work",
                "Bad grades",
                "Fear of Punishment",
                "Deceased Parent",
                "No School Near"
              ],
              "showOtherItem": true
            },
            {
              "type": "dropdown",
              "name": "child7question12",
              "title": "(7.12)  Did child 7 work in the previous year?",
              "isRequired": true,
              "choices": [
                "Yes: in his/her field",
                "Yes: in his/her family field",
                "Yes: On the farm of someone else",
                "No: does not work"
              ]
            },
            {
              "type": "tagbox",
              "name": "child7question13",
              "visibleIf": "{child7question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(7.13)  What are the types of work did child 7 performed on the farm?",
              "isRequired": true,
              "choices": [
                "Gathering harvested cocoa with permissible weight",
                "Collecting Firewood",
                "Clearing of forest",
                "Felling of trees",
                "Bush burning",
                "Working with Agrochemicals i.e. Purchasing",
                "Assisting with Farm Chores",
                "Working in the farm during pesticide spraying",
                "Re-enter a sprayed farm in less than 12 hours",
                "Using machetes/long cutlass for weeding",
                "Climbing trees higher to cut mistletoe with cutlass",
                "Working with motorized mist blower, knapsack sprayer, and chainsaw",
                "Harvesting overhead cocoa with a sharp hook",
                "Breaking cocoa pods with breaking knife",
                "Carrying heavy load beyond permissible weight",
                "Working on the farm for more than 3 hours per day",
                "Working more than 2 hours/day on a school day",
                "Working without adequate protective clothing",
                "Working alone on the farm in isolation",
                "Working on farm between 6.00 p.m. and 5.30 a.m",
                "Withdrawn from school during cocoa season to do farm work",
                "Working full time on farm and not attending school"
              ]
            },
            {
              "type": "dropdown",
              "name": "child7question14",
              "visibleIf": "{child7question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(7.14)  Daily working hours on a school day",
              "isRequired": true,
              "choices": [
                "Does not work on school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child7question15",
              "visibleIf": "{child7question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(7.15)  Period of work",
              "isRequired": true,
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child7question16",
              "visibleIf": "{child7question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(7.16)  Daily working hours on a non-school day",
              "choices": [
                "Does not work on non school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child7question17",
              "visibleIf": "{child7question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(7.17)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child7question18",
              "visibleIf": "{child7question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(7.18)  Why is child 7 working?",
              "choices": [
                "Skills development",
                "Supplemental income",
                "Family tradition or rural lifestyle",
                "Seasonal farming",
                "Migration and displacement",
                "Assisting aging parent or family members"
              ]
            },
            {
              "type": "dropdown",
              "name": "child7question19",
              "visibleIf": "{child7question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(7.19)  For whom does child 7 work?",
              "choices": [
                "Grandparent",
                "Parent",
                "Guardian",
                "Family Member",
                "Personal",
                "Friend",
                "Neighbor"
              ]
            }
          ]
        },
        {
          "type": "panel",
          "name": "childpanel8",
          "visibleIf": "{childquestion4} >= 8",
          "requiredIf": "{childquestion4} > 7",
          "elements": [
            {
              "type": "text",
              "name": "child8question1",
              "title": "(8.1)  Name of Child 8",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "text",
              "name": "child8question2",
              "title": "(8.2)  Age of Child 8",
              "isRequired": true,
              "inputType": "number",
              "min": 5,
              "max": 17,
              "minErrorText": "The value should not be less than {4}",
              "maxErrorText": "The value should not be greater than {18}"
            },
            {
              "type": "dropdown",
              "name": "child8question3",
              "title": "(8.3)  Gender of Child 8",
              "isRequired": true,
              "choices": [
                "Male",
                "Female"
              ]
            },
            {
              "type": "dropdown",
              "name": "child8question4",
              "title": "(8.4)  Who does child 8 live with?",
              "isRequired": true,
              "choices": [
                "Both Parent",
                "Only Mother",
                "Only Father",
                "Grandparent",
                "Family Member",
                "Guardian",
                "Friend"
              ]
            },
            {
              "type": "dropdown",
              "name": "child8question5",
              "title": "(8.5)  Can child 8 read or write in English?",
              "isRequired": true,
              "choices": [
                "Yes",
                "No"
              ]
            },
            {
              "type": "dropdown",
              "name": "child8question6",
              "title": "(8.6)  Does child 8 go to school?",
              "isRequired": true,
              "choices": [
                "Yes: Currently in School",
                "No: Stop School",
                "No: Never been to School"
              ]
            },
            {
              "type": "text",
              "name": "child8question7",
              "visibleIf": "{child8question6} = 'Yes: Currently in School'",
              "title": "(8.7)  At what age did child 8 start school?",
              "isRequired": true,
              "inputType": "number",
              "min": 1,
              "max": 17
            },
            {
              "type": "text",
              "name": "child8question8",
              "visibleIf": "{child8question6} = 'Yes: Currently in School'",
              "title": "(8.8)  What is the name of child 8 school?",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "dropdown",
              "name": "child8question9",
              "visibleIf": "{child8question6} = 'Yes: Currently in School'",
              "title": "(8.9)  What is child 8 current educational level?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child8question10",
              "visibleIf": "{child8question6} = 'No: Stop School'",
              "title": "(8.10)  At what level/age did child 8 stop school?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child8question11",
              "visibleIf": "{child8question6} = 'No: Stop School'",
              "title": "(8.11)  What are the reasons for absence of schooling?",
              "isRequired": true,
              "choices": [
                "Personal Refusal",
                "Care for sick family Members",
                "Parents can't afford",
                "Lack of school items",
                "Learning to work",
                "Bad grades",
                "Fear of Punishment",
                "Deceased Parent",
                "No School Near"
              ],
              "showOtherItem": true
            },
            {
              "type": "dropdown",
              "name": "child8question12",
              "title": "(8.12)  Did child 8 work in the previous year?",
              "isRequired": true,
              "choices": [
                "Yes: in his/her field",
                "Yes: in his/her family field",
                "Yes: On the farm of someone else",
                "No: does not work"
              ]
            },
            {
              "type": "tagbox",
              "name": "child8question13",
              "visibleIf": "{child8question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(8.13)  What are the types of work did child 8 performed on the farm?",
              "choices": [
                "Gathering harvested cocoa with permissible weight",
                "Collecting Firewood",
                "Clearing of forest",
                "Felling of trees",
                "Bush burning",
                "Working with Agrochemicals i.e. Purchasing",
                "Assisting with Farm Chores",
                "Working in the farm during pesticide spraying",
                "Re-enter a sprayed farm in less than 12 hours",
                "Using machetes/long cutlass for weeding",
                "Climbing trees higher to cut mistletoe with cutlass",
                "Working with motorized mist blower, knapsack sprayer, and chainsaw",
                "Harvesting overhead cocoa with a sharp hook",
                "Breaking cocoa pods with breaking knife",
                "Carrying heavy load beyond permissible weight",
                "Working on the farm for more than 3 hours per day",
                "Working more than 2 hours/day on a school day",
                "Working without adequate protective clothing",
                "Working alone on the farm in isolation",
                "Working on farm between 6.00 p.m. and 5.30 a.m",
                "Withdrawn from school during cocoa season to do farm work",
                "Working full time on farm and not attending school"
              ]
            },
            {
              "type": "dropdown",
              "name": "child8question14",
              "visibleIf": "{child8question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(8.14)  Daily working hours on a school day",
              "choices": [
                "Does not work on school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child8question15",
              "visibleIf": "{child8question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(8.15)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child8question16",
              "visibleIf": "{child8question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(8.16)  Daily working hours on a non-school day",
              "choices": [
                "Does not work on non school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child8question17",
              "visibleIf": "{child8question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(8.17)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "question18",
              "visibleIf": "{child8question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(8.18)  Why is child 8 working?",
              "choices": [
                "Skills development",
                "Supplemental income",
                "Family tradition or rural lifestyle",
                "Seasonal farming",
                "Migration and displacement",
                "Assisting aging parent or family members"
              ]
            },
            {
              "type": "dropdown",
              "name": "child8question19",
              "visibleIf": "{child8question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(8.19)  For whom does child 8 work?",
              "choices": [
                "Grandparent",
                "Parent",
                "Guardian",
                "Family Member",
                "Personal",
                "Friend",
                "Neighbor"
              ]
            }
          ]
        },
        {
          "type": "panel",
          "name": "childpanel9",
          "visibleIf": "{childquestion4} >= 9",
          "requiredIf": "{childquestion4} > 8",
          "elements": [
            {
              "type": "text",
              "name": "child9question1",
              "title": "(9.1)  Name of Child 9",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "text",
              "name": "child9question2",
              "title": "(9.2)  Age of Child 9",
              "isRequired": true,
              "inputType": "number",
              "min": 5,
              "max": 17,
              "minErrorText": "The value should not be less than {4}",
              "maxErrorText": "The value should not be greater than {18}"
            },
            {
              "type": "dropdown",
              "name": "child9question3",
              "title": "(9.3)  Gender of Child 9",
              "isRequired": true,
              "choices": [
                "Male",
                "Female"
              ]
            },
            {
              "type": "dropdown",
              "name": "child9question4",
              "title": "(9.4)  Who does child 9 live with?",
              "choices": [
                "Both Parent",
                "Only Mother",
                "Only Father",
                "Grandparent",
                "Family Member",
                "Guardian",
                "Friend"
              ]
            },
            {
              "type": "dropdown",
              "name": "child9question5",
              "title": "(9.5)  Can child 9 read or write in English?",
              "isRequired": true,
              "choices": [
                "Yes",
                "No"
              ]
            },
            {
              "type": "dropdown",
              "name": "child9question6",
              "title": "(9.6)  Does child 9 go to school?",
              "isRequired": true,
              "choices": [
                "Yes: Currently in School",
                "No: Stop School",
                "No: Never been to School"
              ]
            },
            {
              "type": "text",
              "name": "child9question7",
              "visibleIf": "{child9question6} = 'Yes: Currently in School'",
              "title": "(9.7)  At what age did child 9 start school?",
              "isRequired": true,
              "inputType": "number",
              "min": 1,
              "max": 17
            },
            {
              "type": "text",
              "name": "child9question8",
              "visibleIf": "{child9question6} = 'Yes: Currently in School'",
              "title": "(9.8)  What is the name of child 9 school?",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "dropdown",
              "name": "child9question9",
              "visibleIf": "{child9question6} = 'Yes: Currently in School'",
              "title": "(9.9)  What is child 9 current educational level?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child9question10",
              "visibleIf": "{child9question6} = 'No: Stop School'",
              "title": "(9.10)  At what level/age did child 9 stop school?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child9question11",
              "visibleIf": "{child9question6} = 'No: Stop School'",
              "title": "(9.11)  What are the reasons for absence of schooling?",
              "isRequired": true,
              "choices": [
                "Personal Refusal",
                "Care for sick family Members",
                "Parents can't afford",
                "Lack of school items",
                "Learning to work",
                "Bad grades",
                "Fear of Punishment",
                "Deceased Parent",
                "No School Near"
              ],
              "showOtherItem": true
            },
            {
              "type": "dropdown",
              "name": "child9question12",
              "title": "(9.12)  Did child 9 work in the previous year?",
              "isRequired": true,
              "choices": [
                "Yes: in his/her field",
                "Yes: in his/her family field",
                "Yes: On the farm of someone else",
                "No: does not work"
              ]
            },
            {
              "type": "tagbox",
              "name": "child9question13",
              "visibleIf": "{child9question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(9.13)  What are the types of work did child 9 performed on the farm?",
              "choices": [
                "Gathering harvested cocoa with permissible weight",
                "Collecting Firewood",
                "Clearing of forest",
                "Felling of trees",
                "Bush burning",
                "Working with Agrochemicals i.e. Purchasing",
                "Assisting with Farm Chores",
                "Working in the farm during pesticide spraying",
                "Re-enter a sprayed farm in less than 12 hours",
                "Using machetes/long cutlass for weeding",
                "Climbing trees higher to cut mistletoe with cutlass",
                "Working with motorized mist blower, knapsack sprayer, and chainsaw",
                "Harvesting overhead cocoa with a sharp hook",
                "Breaking cocoa pods with breaking knife",
                "Carrying heavy load beyond permissible weight",
                "Working on the farm for more than 3 hours per day",
                "Working more than 2 hours/day on a school day",
                "Working without adequate protective clothing",
                "Working alone on the farm in isolation",
                "Working on farm between 6.00 p.m. and 5.30 a.m",
                "Withdrawn from school during cocoa season to do farm work",
                "Working full time on farm and not attending school"
              ]
            },
            {
              "type": "dropdown",
              "name": "child9question14",
              "visibleIf": "{child9question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(9.14)  Daily working hours on a school day",
              "choices": [
                "Does not work on school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child9question15",
              "visibleIf": "{child9question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(9.15)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child9question16",
              "visibleIf": "{child9question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(9.16)  Daily working hours on a non-school day",
              "choices": [
                "Does not work on non school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child9question17",
              "visibleIf": "{child9question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(9.17)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child9question18",
              "visibleIf": "{child9question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(9.18)  Why is child 9 working?",
              "choices": [
                "Skills development",
                "Supplemental income",
                "Family tradition or rural lifestyle",
                "Seasonal farming",
                "Migration and displacement",
                "Assisting aging parent or family members"
              ]
            },
            {
              "type": "dropdown",
              "name": "child9question19",
              "visibleIf": "{child9question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(9.19)  For whom does child 9 work?",
              "choices": [
                "Grandparent",
                "Parent",
                "Guardian",
                "Family Member",
                "Personal",
                "Friend",
                "Neighbor"
              ]
            }
          ]
        },
        {
          "type": "panel",
          "name": "childpanel10",
          "visibleIf": "{childquestion4} >= 10",
          "requiredIf": "{childquestion4} > 9",
          "elements": [
            {
              "type": "text",
              "name": "child10question1",
              "title": "(10.1)  Name of Child 10",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "text",
              "name": "child10question2",
              "title": "(10.2)  Age of Child 10",
              "isRequired": true,
              "inputType": "number",
              "min": 5,
              "max": 17,
              "minErrorText": "The value should not be less than {4}",
              "maxErrorText": "The value should not be greater than {18}"
            },
            {
              "type": "dropdown",
              "name": "child10question3",
              "title": "(10.3)  Gender of Child 10",
              "isRequired": true,
              "choices": [
                "Male",
                "Female"
              ]
            },
            {
              "type": "dropdown",
              "name": "child10question4",
              "title": "(10.4)  Who does child 10 live with?",
              "isRequired": true,
              "choices": [
                "Both Parent",
                "Only Mother",
                "Only Father",
                "Grandparent",
                "Family Member",
                "Guardian",
                "Friend"
              ]
            },
            {
              "type": "dropdown",
              "name": "child10question5",
              "title": "(10.5)  Can child 10 read or write in English?",
              "isRequired": true,
              "choices": [
                "Yes",
                "No"
              ]
            },
            {
              "type": "dropdown",
              "name": "child10question6",
              "title": "(10.6)  Does child 10 go to school?",
              "isRequired": true,
              "choices": [
                "Yes: Currently in School",
                "No: Stop School",
                "No: Never been to School"
              ]
            },
            {
              "type": "text",
              "name": "child10question7",
              "visibleIf": "{child10question6} = 'Yes: Currently in School'",
              "title": "(10.7)  At what age did child 10 start school?",
              "isRequired": true,
              "inputType": "number",
              "min": 1,
              "max": 17
            },
            {
              "type": "text",
              "name": "child10question8",
              "visibleIf": "{child10question6} = 'Yes: Currently in School'",
              "title": "(10.8)  What is the name of child 10 school?",
              "isRequired": true,
              "maxLength": 50
            },
            {
              "type": "dropdown",
              "name": "child10question9",
              "visibleIf": "{child10question6} = 'Yes: Currently in School'",
              "title": "(10.9)  What is child 10 current educational level?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child10question10",
              "visibleIf": "{child10question6} = 'No: Stop School'",
              "title": "(10.10)  At what level/age did child 10 stop school?",
              "isRequired": true,
              "choices": [
                "KG",
                "Primary",
                "JHS",
                "SHS"
              ]
            },
            {
              "type": "dropdown",
              "name": "child10question11",
              "visibleIf": "{child10question6} = 'No: Stop School'",
              "title": "(10.11)  What are the reasons for absence of schooling?",
              "isRequired": true,
              "choices": [
                "Personal Refusal",
                "Care for sick family Members",
                "Parents can't afford",
                "Lack of school items",
                "Learning to work",
                "Bad grades",
                "Fear of Punishment",
                "Deceased Parent",
                "No School Near"
              ],
              "showOtherItem": true
            },
            {
              "type": "dropdown",
              "name": "child10question12",
              "title": "(10.12)  Did child 10 work in the previous year?",
              "isRequired": true,
              "choices": [
                "Yes: in his/her field",
                "Yes: in his/her family field",
                "Yes: On the farm of someone else",
                "No: does not work"
              ]
            },
            {
              "type": "tagbox",
              "name": "child10question13",
              "visibleIf": "{child10question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(10.13)  What are the types of work did child 10 performed on the farm?",
              "isRequired": true,
              "choices": [
                "Gathering harvested cocoa with permissible weight",
                "Collecting Firewood",
                "Clearing of forest",
                "Felling of trees",
                "Bush burning",
                "Working with Agrochemicals i.e. Purchasing",
                "Assisting with Farm Chores",
                "Working in the farm during pesticide spraying",
                "Re-enter a sprayed farm in less than 12 hours",
                "Using machetes/long cutlass for weeding",
                "Climbing trees higher to cut mistletoe with cutlass",
                "Working with motorized mist blower, knapsack sprayer, and chainsaw",
                "Harvesting overhead cocoa with a sharp hook",
                "Breaking cocoa pods with breaking knife",
                "Carrying heavy load beyond permissible weight",
                "Working on the farm for more than 3 hours per day",
                "Working more than 2 hours/day on a school day",
                "Working without adequate protective clothing",
                "Working alone on the farm in isolation",
                "Working on farm between 6.00 p.m. and 5.30 a.m",
                "Withdrawn from school during cocoa season to do farm work",
                "Working full time on farm and not attending school"
              ]
            },
            {
              "type": "dropdown",
              "name": "child10question14",
              "visibleIf": "{child10question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(10.14)  Daily working hours on a school day",
              "isRequired": true,
              "choices": [
                "Does not work on school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child10question15",
              "visibleIf": "{child10question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(9.15)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child10question16",
              "visibleIf": "{child10question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(10.16)  Daily working hours on a non-school day",
              "choices": [
                "Does not work on non school days",
                "1 hours",
                "2 hours",
                "3 hours",
                "4 hours",
                "5 hours",
                "More than 5 hours"
              ]
            },
            {
              "type": "dropdown",
              "name": "child10question17",
              "visibleIf": "{child10question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(10.17)  Period of work",
              "choices": [
                "Morning",
                "Afternoon",
                "Evening"
              ]
            },
            {
              "type": "dropdown",
              "name": "child10question18",
              "visibleIf": "{child10question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(10.18)  Why is child 10 working?",
              "choices": [
                "Skills development",
                "Supplemental income",
                "Family tradition or rural lifestyle",
                "Seasonal farming",
                "Migration and displacement",
                "Assisting aging parent or family members"
              ]
            },
            {
              "type": "dropdown",
              "name": "child10question19",
              "visibleIf": "{child10question12} anyof ['Yes: in his/her field', 'Yes: in his/her family field', 'Yes: On the farm of someone else']",
              "title": "(10.19)  For whom does child 10 work?",
              "choices": [
                "Grandparent",
                "Parent",
                "Guardian",
                "Family Member",
                "Personal",
                "Friend",
                "Neighbor"
              ]
            }
          ]
        },
        {
          "type": "text",
          "name": "childquestion5",
          "title": "(4) Please write any personal observation (e.g blind, deaf, dumb, no arms/legs)",
          "maxLength": 100
        },
        {
          "type": "panel",
          "name": "location_panel",
          "elements": [
            {
              "type": "text",
              "name": "child_location",
              "title": "Geo - Location",
              "isRequired": true,
              "readOnly": true
            },
            {
              "type": "html",
              "name": "getChLocation",
              "html": "<div id='location-container' style='text-align: center;'>\
              <button id='getChLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button>\</div>"
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
