const json = {
  "logoPosition": "right",
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "dropdown",
          "name": "penquestion1",
          "title": "Select district",
          "isRequired": true,
          "choices": [
            "Tepa",
            "Bechem"
          ],
          "otherText": "Other (Specify)"
        },
        {
          "type": "dropdown",
          "name": "penquestion2",
          "title": "Select community",
          "isRequired": true,
          "choices": [
            "Bomaa",
            "Derma",
            "Dumakwai",
            "Subompan",
            "Techimantia"
          ],
          "showOtherItem": true,
          "otherText": "Other (Specify)"
        },
        {
          "type": "text",
          "name": "question1",
          "title": "Date",
          "inputType": "date"
        },
        {
          "type": "text",
          "name": "question2",
          "title": "Duration"
        },
        {
          "type": "text",
          "name": "question3",
          "title": "Year of Certification\r\n",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "question4",
          "title": "Farmers in attendance\r\n",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "question5",
          "title": "Number of male\r\n",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "question6",
          "title": "Number of Female",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "question7",
          "title": "% of Male\r\n",
          "inputType": "number"
        },
        {
          "type": "text",
          "name": "question8",
          "title": "% of Female",
          "inputType": "number"
        },
        {
          "type": "tagbox",
          "name": "question9",
          "title": "Training Topics (Checkbox of all training)\r\n",
          "choices": [
            "Item 1",
            "Item 2",
            "Item 3"
          ]
        },
        {
          "type": "text",
          "name": "question10",
          "title": "Facilitator’s Name\r\n"
        },
        {
          "type": "signaturepad",
          "name": "question11",
          "title": "Facilitator’s Signature\r\n"
        },
        {
          "type": "text",
          "name": "question12",
          "title": "Coordinate of location\r\n"
        },
        {
          "type": "imagepicker",
          "name": "question13",
          "title": "Farmer’s Thumbprint (Picture)\r\n",
          "imageFit": "cover"
        },
        {
          "type": "panel",
          "name": "question14",
          "elements": [
            {
              "type": "html",
              "name": "question15"
            }
          ]
        },
        {
          "type": "slider",
          "name": "question16",
          "title": "The objectives of the training were met\r\n",
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "question17",
          "title": "The presenter(s) were engaging\r\n",
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "question18",
          "title": "The presentation materials were relevant\r\n",
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "question19",
          "title": "The course length was appropriate\r\n",
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "question20",
          "title": "The pace of the course was appropriate to the content and attendees\r\n",
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "question21",
          "title": "The exercises/role play were helpful and relevant\r\n",
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "slider",
          "name": "question22",
          "title": "The venue was appropriate for the event\r\n",
          "min": 1,
          "max": 3,
          "labelCount": 3
        },
        {
          "type": "text",
          "name": "question23",
          "title": "Evaluation %: Strongly Agree (Total of level of agreements divided by 21 times 100) Eg:(19/21)x100\r\n"
        },
        {
          "type": "text",
          "name": "question24",
          "title": "Other comments\r\n"
        }
      ]
    }
  ]
}






//const json = {
//  "pages": [
//    {
//      "name": "page1",
//      "elements": [
//        {
//          "type": "text",
//          "name": "farmer_id",
//          "title": "Farmer ID",
//          "readOnly": true
//        },
//        {
//          "type": "text",
//          "name": "farmer_name",
//          "title": "Farmer Name",
//          "readOnly": true
//        },
//        {
//          "type": "text",
//          "name": "gender",
//          "title": "Gender",
//          "readOnly": true
//        },
//        {
//          "type": "text",
//          "name": "district",
//          "title": "District",
//          "readOnly": true
//        },
//        {
//          "type": "text",
//          "name": "community",
//          "title": "Community",
//          "readOnly": true
//        },
//        {
//          "type": "text",
//          "name": "plot_id",
//          "title": "Plot ID",
//          "readOnly": true
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question1",
//          "title": "[BS 1.2.1] Producer is aware and comply with applicable laws relevant to the scope of the Rainforest Alliance Standard. Including but not limited to:\n*Land use right\n*Environment\n*Labor\n*Human rights\n*FPIC\n*Taxes and anti-corruption issues",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question1b",
//          "visibleIf": "{inspection_question1} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question1} = 'Yes'",
//          "requiredIf": "{inspection_question1} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question2",
//          "title": "[1.2.5] For permanent workers, up-to-date records are kept, containing, for each worker:\n* Full name\n* Gender\n* Year of birth\n* Wages, including benefits\nFor temporary workers, only the number of workers is required.\nIlliterate group members can give the above information orally",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question2b",
//          "visibleIf": "{inspection_question2} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question2} = 'Yes'",
//          "requiredIf": "{inspection_question2} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question3",
//          "title": "[1.2.7] Farmer has a copy of contract and understands the content of contract signed",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question3b",
//          "visibleIf": "{inspection_question3} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question3} = 'Yes'",
//          "requiredIf": "{inspection_question3} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question4",
//          "title": "[1.2.8]  Records for certification purposes and compliance are kept for a minimum of five years.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question4b",
//          "visibleIf": "{inspection_question4} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question4} = 'Yes'",
//          "requiredIf": "{inspection_question4} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question5",
//          "title": "[1.5.1] Farmer knows the grievance mechanism and understands the system in place",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question5b",
//          "visibleIf": "{inspection_question5} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question5} = 'Yes'",
//          "requiredIf": "{inspection_question5} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question6",
//          "title": "[2.1.8] Do you keep sales receipts (electronic or physical), including name of group member, group member ID,date, product type, and volume.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question6b",
//          "visibleIf": "{inspection_question6} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question6} = 'Yes'",
//          "requiredIf": "{inspection_question6} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question7",
//          "title": "[3.1.3] Farmer has received premium and receipt of premium is available.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question7b",
//          "visibleIf": "{inspection_question7} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question7} = 'Yes'",
//          "requiredIf": "{inspection_question7} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question8",
//          "title": "[4.1.1] Are your Plant varieties (planting, grafting and renovation) selected based on quality, productivity, resistance to pests and diseases and on suitability for the climate during the lifetime of the plants.\nPlanting materials are free of pests and diseases",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question8b",
//          "visibleIf": "{inspection_question8} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question8} = 'Yes'",
//          "requiredIf": "{inspection_question8} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question9",
//          "title": "[4.1.2] For new plantings, Do you follow a well-established cropping system that considers various factors, including:\n* Requirements of the variety used\n* Geographical, ecological, and agronomic conditions\n* Diversification and intercropping crops with different rooting depths and soil uses to enhance soil quality and\nhealth\n* Planting density",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question9b",
//          "visibleIf": "{inspection_question9} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question9} = 'Yes'",
//          "requiredIf": "{inspection_question9} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question10",
//          "title": "[4.1.3] Based on IPM strategy, Do you implement measures to prevent pests and diseases and to break their biological\ncycles, to support soil health and to improve weed management. Such measures can include intercropping, and\nmeasures taken in between crop cycles, such as crop rotation or leaving the land fallow.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question10b",
//          "visibleIf": "{inspection_question10} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question10} = 'Yes'",
//          "requiredIf": "{inspection_question10} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question11",
//          "title": "[4.2.1] Do you implement a pruning cycle for the formation, maintenance, and rejuvenation of crops according to their\nneeds, agroecological conditions, and applicable pruning guidelines.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question11b",
//          "visibleIf": "{inspection_question11} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question11} = 'Yes'",
//          "requiredIf": "{inspection_question11} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question12",
//          "title": "[4.3.1] The certified crop is not genetically modified (GMO)",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question12b",
//          "visibleIf": "{inspection_question12} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question12} = 'Yes'",
//          "requiredIf": "{inspection_question12} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question13",
//          "title": "[4.4.3] Do you prioritize the use of farm-made organic fertilizers. If additional nutrients are needed, they supplement with other organic or inorganic fertilizers. Animal manure is hot composted to reduce risk and stored at least 25 meters from water bodies",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question13b",
//          "visibleIf": "{inspection_question13} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question13} = 'Yes'",
//          "requiredIf": "{inspection_question13} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question14",
//          "title": "[4.6.1] Do you use agrochemicals that are:\n* On the Rainforest Alliance List of Prohibited Pesticides or List of Obsolete Pesticides\n* Prohibited by applicable law\n* Not legally registered in the country where the farm is located\nProducers use only agrochemicals sold by authorized vendors, in original and sealed packaging.\nChemical substances used for livestock or pets are not included in the scope of this standard",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question14b",
//          "visibleIf": "{inspection_question14} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question14} = 'Yes'",
//          "requiredIf": "{inspection_question14} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question15",
//          "title": "[4.6.2] Do you implement all relevant practices described in the farming annex if pesticides used are on the Risk mitigation list? Do you use the  pesticides under the Exceptional Use Policy must follow all respective practices detailed in this policy and adhere to the procedure for requesting and reporting exceptions as outlined in the annex.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question15b",
//          "visibleIf": "{inspection_question15} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question15} = 'Yes'",
//          "requiredIf": "{inspection_question15} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question16",
//          "title": "[4.6.3 1] Do you handle or apply agrochemicals (e.g., pesticides) on your farm? \n2. If yes, have you received training on how to prepare and apply these chemicals safely, including the use of protective equipment?                                                                            ",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question16b",
//          "visibleIf": "{inspection_question16} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question16} = 'Yes'",
//          "requiredIf": "{inspection_question16} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question17",
//          "title": "[4.6.4] Do Pesticide handlers bathe, change, and wash clothes after application. Management should provide them with a private area, water, soap, and, if possible, bathing facilities",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question17b",
//          "visibleIf": "{inspection_question17} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question17} = 'Yes'",
//          "requiredIf": "{inspection_question17} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question18",
//          "title": "[4.6.5] Are Pesticides prepared and applied according to the label, MSDS or security tag, or as recommended by an official\nnational organization or a competent technician, especially with regards to:\n* Safe transport to area of application\n* Respecting the correct dosage\n* Using appropriate equipment and techniques\n* Appropriate weather conditions\n* Respecting restricted entry intervals (REI), including warning signs in local language and informing potentially\naffected persons or communities in advance. Pre-harvest intervals are respected as well",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question18b",
//          "visibleIf": "{inspection_question18} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question18} = 'Yes'",
//          "requiredIf": "{inspection_question18} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question19",
//          "title": "[4.6.6] Mechanisms are in place to prevent contamination by pesticides, through spray drift or other means, from treated areas to other areas including all aquatic and terrestrial ecosystems and infrastructure. These mechanisms include non-crop vegetative barriers, non-application zones, or other effective measures",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question19b",
//          "visibleIf": "{inspection_question19} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question19} = 'Yes'",
//          "requiredIf": "{inspection_question19} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question20",
//          "title": "[4.6.7] Aerial application is only allowed under the conditions as outlined in the Farming Annex",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question20b",
//          "visibleIf": "{inspection_question20} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question20} = 'Yes'",
//          "requiredIf": "{inspection_question20} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question21",
//          "title": "[4.6.8] Pesticide applications are recorded. Records include:\n* Product brand name and active ingredient(s)\n* Date and time of application\n* Location and area (size) of application\n* Dosage and volume (organic or inorganic)\n* Crop\n* Name(s) of applicator(s)\n* Target pest",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question21b",
//          "visibleIf": "{inspection_question21} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question21} = 'Yes'",
//          "requiredIf": "{inspection_question21} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question22",
//          "title": "[4.6.9] Empty pesticide containers and application equipment are washed three times, with the rinsing water used in the final batch of the mix for crop application. After applying pesticides, application equipment is washed three times, and any leftover mix is diluted with ten times the amount of clean water and applied evenly on the treated field to minimize environmental and health impacts. Empty pesticide containers are stored securely until they can be disposed of safely. Prohibited, obsolete, and expired pesticides are returned to the supplier or local authority or labeled and stored safely and separately from other products in a locked space",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question22b",
//          "visibleIf": "{inspection_question22} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question22} = 'Yes'",
//          "requiredIf": "{inspection_question22} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question23",
//          "title": "[4.6.10] Agrochemicals and application equipment are stored in accordance with label instructions to ensure minimal negative impact on the environment and human health. Agrochemicals must remain in their original containers or packaging.\nFacilities for storing agrochemicals and application equipment should be:\n* Dry, clean, and well-ventilated\n* Constructed from non-absorbent materials\n* Securely locked and accessible only by trained handlers\n* Inaccessible to children\n* Separated from crops, food products, and packaging materials",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question23b",
//          "visibleIf": "{inspection_question23} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question23} = 'Yes'",
//          "requiredIf": "{inspection_question23} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question24",
//          "title": "[4.7.1] Do you handle cocoa in a manner to maintain quality and quantity during harvest and post-harvest stages, such as loading, processing, packing, transportation, and storage. This includes:\n* Harvesting products at the right time to optimize quality\n* Minimizing plant damage for future production\n* Preventing contamination from foreign matter, cleaning products, agrochemicals, microbes, and pests\n* Avoiding moisture damage\n* Storing products in a cool, dry, dark, and well-ventilated place\n* Maintaining and cleaning tools, machinery, and equipment used in harvest and post-harvest\n* Using suitable and approved packaging materials for food products",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question24b",
//          "visibleIf": "{inspection_question24} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question24} = 'Yes'",
//          "requiredIf": "{inspection_question24} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question25",
//          "title": "[5.2.1] Workers can form and join unions or workers' organizations of their choice and participate in collective bargaining\nwithout employer approval, as per applicable law. Workers’ representatives are elected democratically in regular\nfree and fair elections. For small farms, the requirement only applies if they are hiring:\n- 10 or more temporary workers each working for three consecutive months or more, and/or\n- 50 or more temporary workers per calendar year",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question25b",
//          "visibleIf": "{inspection_question25} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question25} = 'Yes'",
//          "requiredIf": "{inspection_question25} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question26",
//          "title": "[5.2.2] Workers are protected from discrimination or retaliation due to union activities. Management cannot punish, bribe,\nor influence union members or representatives. For small farms, the requirement only applies if they are hiring:\n- 10 or more temporary workers each working for three consecutive months or more, and/or\n- 50 or more temporary workers per calendar year",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question26b",
//          "visibleIf": "{inspection_question26} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question26} = 'Yes'",
//          "requiredIf": "{inspection_question26} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question27",
//          "title": "[5.3.1] Workers employed for 3 consecutive months or more must have a written contract signed by both parties. Those\nemployed for less than 3 months must have at least a verbal contract, with the employer keeping records of these\ncontracts. Written contracts for workers employed 3 consecutive months or more include:\n* Job duties\n* Job location\n* Working hours\n* Pay rate/method of calculation\n* Overtime pay rate\n*Payment schedule\n* Deductions and benefits\n* Paid leave\n* Medical leave and protections for illness, disability, or accident\n* Notice period for termination\nVerbal contract records include:\n* Working hours\n* Pay rate\n* Overtime pay\nAll workers understand their employment contracts before starting work and can request a copy anytime.\nFor small farms, the requirement only applies if they are hiring:\n- 10 or more temporary workers each working for three consecutive months or more, and/or\n- 50 or more temporary workers per calendar year.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question27b",
//          "visibleIf": "{inspection_question27} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question27} = 'Yes'",
//          "requiredIf": "{inspection_question27} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question28",
//          "title": "[5.3.2] There are no policies and/or arrangements to reduce workers' pay or benefits, such as using temporary workers for\npermanent tasks.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question28b",
//          "visibleIf": "{inspection_question28} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question28} = 'Yes'",
//          "requiredIf": "{inspection_question28} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question29",
//          "title": "[5.3.3] Do producers and management adhere to collective bargaining agreements (CBA) relevant to the Rainforest Alliance Standard.\nWorkers are paid at least the applicable minimum wage or the wage stipulated in a CBA, whichever is higher. For production quota or piece work, the payment must meet at least the minimum wage, based on a 48-hour working week or the national legal working hours limit, whichever is lower.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question29b",
//          "visibleIf": "{inspection_question29} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question29} = 'Yes'",
//          "requiredIf": "{inspection_question29} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question30",
//          "title": "[5.3.4] Deductions from wages for social security are only allowed if specified by applicable law or CBA. Voluntary deductions, like advance payments or loans, require worker consent. Employers must handle these remittances fully and in a timely manner. Disciplinary wage deductions are prohibited. Deductions for tools or gear are not allowed unless legally permitted. In-kind benefits must comply with the law and cannot exceed 30% of total pay",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question30b",
//          "visibleIf": "{inspection_question30} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question30} = 'Yes'",
//          "requiredIf": "{inspection_question30} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question31",
//          "title": "[5.3.5] Do Workers receive payments at regular intervals as agreed upon by both the worker and the employer",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question31b",
//          "visibleIf": "{inspection_question31} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question31} = 'Yes'",
//          "requiredIf": "{inspection_question31} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question32",
//          "title": "[5.3.6] Work of equal value receives equal remuneration, free from discrimination on grounds such as gender, worker type,\nethnicity, age, color, religion, political opinion, nationality, social origin, or other factors",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question32b",
//          "visibleIf": "{inspection_question32} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question32} = 'Yes'",
//          "requiredIf": "{inspection_question32} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question33",
//          "title": "[5.3.7] If labor providers are used, records are kept including the name, contact details and official registration number (if\navailable).\nThe labor provider is:\n* Not engaged in fraudulent or coercive recruiting practices.\n* Compliant with applicable worker-related requirements 5.3 and 5.5 of this standard.\nAll recruitment fees are paid by the farm, not by workers.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question33b",
//          "visibleIf": "{inspection_question33} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question33} = 'Yes'",
//          "requiredIf": "{inspection_question33} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question34",
//          "title": "[5.5.1] Workers do not exceed eight regular working hours per day or 48 hours per week. They receive a 30-minute break\nafter six consecutive hours and one full rest day after six consecutive working days. Guards do not exceed 60 hours\nper week or the applicable regulation, whichever is stricter.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question34b",
//          "visibleIf": "{inspection_question34} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question34} = 'Yes'",
//          "requiredIf": "{inspection_question34} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question35",
//          "title": "[5.5.2] Overtime work is voluntary and allowed if:\na) It is requested timely. For small farms, requirement only applies if they are hiring:\n- 10 or more temporary workers each working for 3 consecutive months or more, and/or\n- 50 or more temporary workers per calendar year",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question35b",
//          "visibleIf": "{inspection_question35} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question35} = 'Yes'",
//          "requiredIf": "{inspection_question35} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question36",
//          "title": "[5.5.3] Permanent workers are entitled to paid parental leave, rights and benefits in accordance with applicable law. In absence of such law, workers receive paid maternity leave of at least 12 weeks, of which at least six weeks are taken after birth. They can return to their job after maternity leave on the same terms and conditions and without discrimination, loss of seniority or deduction of wages. Workers who are pregnant, nursing or have recently given birth are offered flexible working schedules and work site arrangements. Breastfeeding women have two additional 30-minute breaks per day and an appropriate space for breastfeeding to nurture the child. ",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question36b",
//          "visibleIf": "{inspection_question36} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question36} = 'Yes'",
//          "requiredIf": "{inspection_question36} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question37",
//          "title": "[5.5.4] Do Children of workers who are below the applicable minimum working age and accompanying their parents to the\nworkplace must:\n* Be provided with a safe area appropriate for their age.\n* Be under continuous supervision by adults at all times.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question37b",
//          "visibleIf": "{inspection_question37} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question37} = 'Yes'",
//          "requiredIf": "{inspection_question37} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question38",
//          "title": "[5.6.2] Group members are aware of the availability of first aid and where to receive treatment should the need be",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question38b",
//          "visibleIf": "{inspection_question38} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question38} = 'Yes'",
//          "requiredIf": "{inspection_question38} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question39",
//          "title": "[5.6.3] Do Group members and workers know emergency procedures. Warning signs and safety instructions are clearly\ndisplayed. Workers can leave imminent danger situations without permission or penalty.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question39b",
//          "visibleIf": "{inspection_question39} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question39} = 'Yes'",
//          "requiredIf": "{inspection_question39} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question40",
//          "title": "[5.6.4/5.6.6] Group members' Workers have access to sufficient and safe drinking water at all times",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question40b",
//          "visibleIf": "{inspection_question40} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question40} = 'Yes'",
//          "requiredIf": "{inspection_question40} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question41",
//          "title": "[5.6.8] Workers in hazardous conditions (e.g. Under challenging terrain, with machines or with hazardous materials) use\nPersonal Protective Equipment (PPE) provided for free and receive training on how to use them.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question41b",
//          "visibleIf": "{inspection_question41} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question41} = 'Yes'",
//          "requiredIf": "{inspection_question41} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question42",
//          "title": "[5.6.9] Machinery and other equipment are securely stored when not in use.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question42b",
//          "visibleIf": "{inspection_question42} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question42} = 'Yes'",
//          "requiredIf": "{inspection_question42} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question43",
//          "title": "[5.6.10] Female workers who are pregnant, nursing, or have recently given birth are not assigned to activities that pose a risk\nto their health or the health of their unborn child or infant. In cases of job reassignment, there is no reduction in\nremuneration. Pregnancy tests are not requested.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question43b",
//          "visibleIf": "{inspection_question43} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question43} = 'Yes'",
//          "requiredIf": "{inspection_question43} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question44",
//          "title": "[5.7.3] Workers and their families housed on-site have safe, clean, and decent living conditions that consider local  standards. These include:\n* Safe accommodation in non-hazardous locations, with protection from extreme weather, dry floors, permanent walls, and well-maintained structures.\n* Marked evacuation routes for group accommodations.\n* Protection against air pollution and surface runoff, with adequate sewage, sanitation, and waste disposal facilities.\n* Access to safe drinking water.\n* Adequate sanitary and washing facilities, ensuring the safety and privacy of vulnerable groups through well-lit and lockable facilities",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question44b",
//          "visibleIf": "{inspection_question44} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question44} = 'Yes'",
//          "requiredIf": "{inspection_question44} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question45",
//          "title": "[5.8.2] Do you have a legal or legitimate right to use the land, substantiated by ownership, leasehold, or other legal documents or by documentation of traditional or customary use rights. Verifiable traditional or customary use rights\nmay also be used.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question45b",
//          "visibleIf": "{inspection_question45} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question45} = 'Yes'",
//          "requiredIf": "{inspection_question45} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question46",
//          "title": "[6.1.1] From January 1st, 2014, onward, have you converted natural forests and other natural ecosystems into agricultural production or other land uses?.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question46b",
//          "visibleIf": "{inspection_question46} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question46} = 'Yes'",
//          "requiredIf": "{inspection_question46} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question47",
//          "title": "[6.1.2] Production or processing does not occur in protected areas or their officially designated buffer zones, except where it complies with applicable law.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question47b",
//          "visibleIf": "{inspection_question47} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question47} = 'Yes'",
//          "requiredIf": "{inspection_question47} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question48",
//          "title": "[6.2.2] Farms preserve all remnant forest trees unless they present hazards to people or infrastructure. Other native trees on the farm are managed sustainably to ensure that the same quantity and quality of trees is maintained.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question48b",
//          "visibleIf": "{inspection_question48} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question48} = 'Yes'",
//          "requiredIf": "{inspection_question48} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question49",
//          "title": "[6.2.3/6.2.4] Producers maintain natural vegetation cover. Natural vegetation can include one or more of the following (not exclusive):\n* Riparian buffers\n* Conservation areas within the farm\n* Natural vegetation in agroforestry systems\n* Border plantings, live fences and barriers around housing and infrastructure, or in other ways\n* Conservation and restoration areas outside the certified farm that effectively provide long-term protection of the subject areas ",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question49b",
//          "visibleIf": "{inspection_question49} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question49} = 'Yes'",
//          "requiredIf": "{inspection_question49} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question50",
//          "title": "[6.3.1] Farms maintain existing riparian buffers adjacent to aquatic ecosystems",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question50b",
//          "visibleIf": "{inspection_question50} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question50} = 'Yes'",
//          "requiredIf": "{inspection_question50} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question51",
//          "title": "[6.3.2] Producers maintain the following additional safeguards for the protection of drinking water in case the farm is \nlocated closer than 50m from a river, lake, or other water body that is frequently used as the main source of drinking. \n• Maintain or establish a riparian buffer that is at least 10m wide \n• Add an outer, additional 20m non-application zone (total 30m) where no pesticides or fertilizers are used \n• Add an additional 20m zone (from 30 to 50m from the waterbody), in which pesticides are only applied \nthrough mechanical, hand-assisted or targeted application ",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question51b",
//          "visibleIf": "{inspection_question51} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question51} = 'Yes'",
//          "requiredIf": "{inspection_question51} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question52",
//          "title": "[6.4.1] Threatened animals and plants are not hunted, killed, fished, collected, or trafficked.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question52b",
//          "visibleIf": "{inspection_question52} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question52} = 'Yes'",
//          "requiredIf": "{inspection_question52} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question53",
//          "title": "[6.4.2] Producers do not keep wildlife in captivity",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question53b",
//          "visibleIf": "{inspection_question53} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question53} = 'Yes'",
//          "requiredIf": "{inspection_question53} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question54",
//          "title": "[6.4.3] Producers avoid intentionally introducing or releasing invasive species.\nProducers do not dispose of existing invasive species or their parts in aquatic ecosystems",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question54b",
//          "visibleIf": "{inspection_question54} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question54} = 'Yes'",
//          "requiredIf": "{inspection_question54} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question55",
//          "title": "[6.4.4] Producers do not use wildlife for processing or harvesting of any crop",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question55b",
//          "visibleIf": "{inspection_question55} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question55} = 'Yes'",
//          "requiredIf": "{inspection_question55} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question56",
//          "title": "[6.4.5] Erosion by water and wind is reduced through practices such as re-vegetation of steep areas and terracing",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question56b",
//          "visibleIf": "{inspection_question56} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question56} = 'Yes'",
//          "requiredIf": "{inspection_question56} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question57",
//          "title": "[6.4.6] Fire is not used for preparing or cleaning fields, except when specifically justified in the IPM plan",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question57b",
//          "visibleIf": "{inspection_question57} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question57} = 'Yes'",
//          "requiredIf": "{inspection_question57} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question58",
//          "title": "[6.5.5] Producers use rainwater harvesting for irrigation and/or other agricultural purposes",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question58b",
//          "visibleIf": "{inspection_question58} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question58} = 'Yes'",
//          "requiredIf": "{inspection_question58} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question59",
//          "title": "[6.5.6] Producers participate in a local watershed committee or initiative and take action to help maintain or restore the watershed’s health as part of this collective process. The nature of the participation and actions taken are documented.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question59b",
//          "visibleIf": "{inspection_question59} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question59} = 'Yes'",
//          "requiredIf": "{inspection_question59} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question60",
//          "title": "[6.6.2] Human sewage, sludge, and sewage water are not used in production or processing",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question60b",
//          "visibleIf": "{inspection_question60} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question60} = 'Yes'",
//          "requiredIf": "{inspection_question60} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question61",
//          "title": "[6.6.3] Wastewater from processing operations is only used on land after treatment to remove particulates and toxins. Treated wastewater for irrigation must meet specific parameters for both wastewater and irrigation",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question61b",
//          "visibleIf": "{inspection_question61} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question61} = 'Yes'",
//          "requiredIf": "{inspection_question61} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question62",
//          "title": "[6.7.1] Waste is managed to avoid health and safety risks. It is stored and disposed of only in designated areas, not in \nnatural ecosystems. Non-organic waste is not left on land.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question62b",
//          "visibleIf": "{inspection_question62} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question62} = 'Yes'",
//          "requiredIf": "{inspection_question62} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question63",
//          "title": "[6.7.2] Producers do not burn waste, except in incinerators technically designed for the specific type of waste.",
//          "isRequired": true,
//          "choices": [
//            "Yes",
//            "No",
//            "N/A"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_question63b",
//          "visibleIf": "{inspection_question63} anyof ['No', 'N/A']",
//          "title": "Provide justification.",
//          "resetValueIf": "{inspection_question63} = 'Yes'",
//          "requiredIf": "{inspection_question63} anyof ['No', 'N/A']"
//        },
//        {
//          "type": "text",
//          "name": "inspection_question64",
//          "title": "Name of the person present during the inspection",
//          "isRequired": true
//        },
//        {
//          "type": "panel",
//          "name": "location_panel",
//          "elements": [
//            {
//              "type": "text",
//              "name": "inspection_location",
//              "title": "Geolocation of farm",
//              "isRequired": true,
//              "readOnly": true
//            },
//            {
//              "type": "html",
//              "name": "getInspectionLocation",
//              "html": "<div id='location-container' style='text-align: center;'><button id='getInspectionLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button></div>"
//            }
//          ]
//        },
//        {
//          "type": "panel",
//          "name": "photo_panel",
//          "title": "Farmer thumbprint",
//          "elements": [
//            {
//              "type": "html",
//              "name": "inspection_photo",
//              "html": "<div id='photo-container' style='text-align: center;'><img id='FarmerPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='Farmer Photo'/><button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button></div>"
//            }
//          ]
//        },
//        {
//          "type": "signaturepad",
//          "name": "signature",
//          "title": "Signature of enumerator",
//          "isRequired": true
//        }
//      ]
//    }
//  ]
//}
//
//
//
//
//
//
//
////const json = {
////  "pages": [
////    {
////      "name": "page1",
////      "elements": [
////        {
////          "type": "text",
////          "name": "farmer_id",
////          "title": "Farmer ID"
////        },
////        {
////          "type": "text",
////          "name": "farmer_name",
////          "title": "Farmer Name"
////        },
////        {
////          "type": "text",
////          "name": "gender",
////          "title": "Gender"
////        },
////        {
////          "type": "text",
////          "name": "district",
////          "title": "District"
////        },
////        {
////          "type": "text",
////          "name": "community",
////          "title": "Community"
////        },
////        {
////          "type": "text",
////          "name": "plot_id",
////          "title": "Plot ID"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question1",
////          "title": "[BS 1.2.1] Producer is aware and comply with applicable laws relevant to the scope of the Rainforest Alliance Standard. Including but not limited to:\n*Land use right\n*Environment\n*Labor\n*Human rights\n*FPIC\n*Taxes and anti-corruption issues",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question1b",
////          "visibleIf": "{inspection_question1} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question1} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question2",
////          "title": "[1.2.5] For permanent workers, up-to-date records are kept, containing, for each worker:\n* Full name\n* Gender\n* Year of birth\n* Wages, including benefits\nFor temporary workers, only the number of workers is required.\nIlliterate group members can give the above information orally",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question2b",
////          "visibleIf": "{inspection_question2} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question2} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question3",
////          "title": "[1.2.8]  Records for certification purposes and compliance are kept for a minimum of five years.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question3b",
////          "visibleIf": "{inspection_question3} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question3} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question4",
////          "title": "[2.1.8] Do you keep sales receipts (electronic or physical), including name of group member, group member ID,date, product type, and volume.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question4b",
////          "visibleIf": "{inspection_question4} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question4} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question5",
////          "title": "[4.1.1] Are your Plant varieties (planting, grafting and renovation) selected based on quality, productivity, resistance to pests and diseases and on suitability for the climate during the lifetime of the plants.\nPlanting materials are free of pests and diseases",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question5b",
////          "visibleIf": "{inspection_question5} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question5} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question6",
////          "title": "[4.1.2] For new plantings, Do you follow a well-established cropping system that considers various factors, including:\n* Requirements of the variety used\n* Geographical, ecological, and agronomic conditions\n* Diversification and intercropping crops with different rooting depths and soil uses to enhance soil quality and\nhealth\n* Planting density",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question6b",
////          "visibleIf": "{inspection_question6} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question6} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question7",
////          "title": "[4.1.3] Based on IPM strategy, Do you implement measures to prevent pests and diseases and to break their biological\ncycles, to support soil health and to improve weed management. Such measures can include intercropping, and\nmeasures taken in between crop cycles, such as crop rotation or leaving the land fallow.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question7b",
////          "visibleIf": "{inspection_question7} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question7} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question8",
////          "title": "[4.2.1] Do you implement a pruning cycle for the formation, maintenance, and rejuvenation of crops according to their\nneeds, agroecological conditions, and applicable pruning guidelines.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question8b",
////          "visibleIf": "{inspection_question8} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question8} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question9",
////          "title": "[4.3.1] The certified crop is not genetically modified (GMO)",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question9b",
////          "visibleIf": "{inspection_question9} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question9} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question10",
////          "title": "[4.4.3] Do you prioritize the use of farm-made organic fertilizers. If additional nutrients are needed, they supplement with other organic or inorganic fertilizers. Animal manure is hot composted to reduce risk and stored at least 25 meters from water bodies",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question10b",
////          "visibleIf": "{inspection_question10} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question10} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question11",
////          "title": "[4.6.1] Do you use agrochemicals that are:\n* On the Rainforest Alliance List of Prohibited Pesticides or List of Obsolete Pesticides\n* Prohibited by applicable law\n* Not legally registered in the country where the farm is located\nProducers use only agrochemicals sold by authorized vendors, in original and sealed packaging.\nChemical substances used for livestock or pets are not included in the scope of this standard",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question11b",
////          "visibleIf": "{inspection_question11} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question11} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question12",
////          "title": "[4.6.2] Do you implement all relevant practices described in the farming annex if pesticides used are on the Risk mitigation list? Do you use the  pesticides under the Exceptional Use Policy must follow all respective practices detailed in this policy and adhere to the procedure for requesting and reporting exceptions as outlined in the annex.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question12b",
////          "visibleIf": "{inspection_question12} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question12} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question13",
////          "title": "[4.6.3 1] Do you handle or apply agrochemicals (e.g., pesticides) on your farm? \n2. If yes, have you received training on how to prepare and apply these chemicals safely, including the use of protective equipment?                                                                            ",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question13b",
////          "visibleIf": "{inspection_question13} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question13} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question14",
////          "title": "[4.6.4] Do Pesticide handlers bathe, change, and wash clothes after application. Management should provide them with a private area, water, soap, and, if possible, bathing facilities",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question14b",
////          "visibleIf": "{inspection_question14} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question14} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question15",
////          "title": "[4.6.5] Are Pesticides prepared and applied according to the label, MSDS or security tag, or as recommended by an official\nnational organization or a competent technician, especially with regards to:\n* Safe transport to area of application\n* Respecting the correct dosage\n* Using appropriate equipment and techniques\n* Appropriate weather conditions\n* Respecting restricted entry intervals (REI), including warning signs in local language and informing potentially\naffected persons or communities in advance. Pre-harvest intervals are respected as well",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question15b",
////          "visibleIf": "{inspection_question15} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question15} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question16",
////          "title": "[4.6.6] Mechanisms are in place to prevent contamination by pesticides, through spray drift or other means, from treated areas to other areas including all aquatic and terrestrial ecosystems and infrastructure. These mechanisms include non-crop vegetative barriers, non-application zones, or other effective measures",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question16b",
////          "visibleIf": "{inspection_question16} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question16} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question17",
////          "title": "[4.6.7] Aerial application is only allowed under the conditions as outlined in the Farming Annex",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question17b",
////          "visibleIf": "{inspection_question17} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question17} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question18",
////          "title": "[4.6.8] Pesticide applications are recorded. Records include:\n* Product brand name and active ingredient(s)\n* Date and time of application\n* Location and area (size) of application\n* Dosage and volume (organic or inorganic)\n* Crop\n* Name(s) of applicator(s)\n* Target pest",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question18b",
////          "visibleIf": "{inspection_question18} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question18} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question19",
////          "title": "[4.6.9] Empty pesticide containers and application equipment are washed three times, with the rinsing water used in the final batch of the mix for crop application. After applying pesticides, application equipment is washed three times, and any leftover mix is diluted with ten times the amount of clean water and applied evenly on the treated field to minimize environmental and health impacts. Empty pesticide containers are stored securely until they can be disposed of safely. Prohibited, obsolete, and expired pesticides are returned to the supplier or local authority or labeled and stored safely and separately from other products in a locked space",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question19b",
////          "visibleIf": "{inspection_question19} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question19} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question20",
////          "title": "[4.6.10] Agrochemicals and application equipment are stored in accordance with label instructions to ensure minimal negative impact on the environment and human health. Agrochemicals must remain in their original containers or packaging.\nFacilities for storing agrochemicals and application equipment should be:\n* Dry, clean, and well-ventilated\n* Constructed from non-absorbent materials\n* Securely locked and accessible only by trained handlers\n* Inaccessible to children\n* Separated from crops, food products, and packaging materials",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question20b",
////          "visibleIf": "{inspection_question20} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question20} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question21",
////          "title": "[4.7.1] Do you handle cocoa in a manner to maintain quality and quantity during harvest and post-harvest stages, such as loading, processing, packing, transportation, and storage. This includes:\n* Harvesting products at the right time to optimize quality\n* Minimizing plant damage for future production\n* Preventing contamination from foreign matter, cleaning products, agrochemicals, microbes, and pests\n* Avoiding moisture damage\n* Storing products in a cool, dry, dark, and well-ventilated place\n* Maintaining and cleaning tools, machinery, and equipment used in harvest and post-harvest\n* Using suitable and approved packaging materials for food products",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question21b",
////          "visibleIf": "{inspection_question21} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question21} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question22",
////          "title": "[5.2.1] Workers can form and join unions or workers' organizations of their choice and participate in collective bargaining\nwithout employer approval, as per applicable law. Workers’ representatives are elected democratically in regular\nfree and fair elections. For small farms, the requirement only applies if they are hiring:\n- 10 or more temporary workers each working for three consecutive months or more, and/or\n- 50 or more temporary workers per calendar year",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question22b",
////          "visibleIf": "{inspection_question22} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question22} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question23",
////          "title": "[5.2.2] Workers are protected from discrimination or retaliation due to union activities. Management cannot punish, bribe,\nor influence union members or representatives. For small farms, the requirement only applies if they are hiring:\n- 10 or more temporary workers each working for three consecutive months or more, and/or\n- 50 or more temporary workers per calendar year",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question23b",
////          "visibleIf": "{inspection_question23} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question23} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question24",
////          "title": "[5.3.1] Workers employed for 3 consecutive months or more must have a written contract signed by both parties. Those\nemployed for less than 3 months must have at least a verbal contract, with the employer keeping records of these\ncontracts. Written contracts for workers employed 3 consecutive months or more include:\n* Job duties\n* Job location\n* Working hours\n* Pay rate/method of calculation\n* Overtime pay rate\n*Payment schedule\n* Deductions and benefits\n* Paid leave\n* Medical leave and protections for illness, disability, or accident\n* Notice period for termination\nVerbal contract records include:\n* Working hours\n* Pay rate\n* Overtime pay\nAll workers understand their employment contracts before starting work and can request a copy anytime.\nFor small farms, the requirement only applies if they are hiring:\n- 10 or more temporary workers each working for three consecutive months or more, and/or\n- 50 or more temporary workers per calendar year.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question24b",
////          "visibleIf": "{inspection_question24} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question24} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question25",
////          "title": "[5.3.2] There are no policies and/or arrangements to reduce workers' pay or benefits, such as using temporary workers for\npermanent tasks.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question25b",
////          "visibleIf": "{inspection_question25} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question25} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question26",
////          "title": "[5.3.3] Do producers and management adhere to collective bargaining agreements (CBA) relevant to the Rainforest Alliance Standard.\nWorkers are paid at least the applicable minimum wage or the wage stipulated in a CBA, whichever is higher. For production quota or piece work, the payment must meet at least the minimum wage, based on a 48-hour working week or the national legal working hours limit, whichever is lower.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question26b",
////          "visibleIf": "{inspection_question26} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question26} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question27",
////          "title": "[5.3.4] Deductions from wages for social security are only allowed if specified by applicable law or CBA. Voluntary deductions, like advance payments or loans, require worker consent. Employers must handle these remittances fully and in a timely manner. Disciplinary wage deductions are prohibited. Deductions for tools or gear are not allowed unless legally permitted. In-kind benefits must comply with the law and cannot exceed 30% of total pay",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question27b",
////          "visibleIf": "{inspection_question27} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question27} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question28",
////          "title": "[5.3.5] Do Workers receive payments at regular intervals as agreed upon by both the worker and the employer",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question28b",
////          "visibleIf": "{inspection_question28} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question28} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question29",
////          "title": "[5.3.6] Work of equal value receives equal remuneration, free from discrimination on grounds such as gender, worker type,\nethnicity, age, color, religion, political opinion, nationality, social origin, or other factors",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question29b",
////          "visibleIf": "{inspection_question29} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question29} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question30",
////          "title": "[5.3.7] If labor providers are used, records are kept including the name, contact details and official registration number (if\navailable).\nThe labor provider is:\n* Not engaged in fraudulent or coercive recruiting practices.\n* Compliant with applicable worker-related requirements 5.3 and 5.5 of this standard.\nAll recruitment fees are paid by the farm, not by workers.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question30b",
////          "visibleIf": "{inspection_question30} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question30} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question31",
////          "title": "[5.5.1] Workers do not exceed eight regular working hours per day or 48 hours per week. They receive a 30-minute break\nafter six consecutive hours and one full rest day after six consecutive working days. Guards do not exceed 60 hours\nper week or the applicable regulation, whichever is stricter.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question31b",
////          "visibleIf": "{inspection_question31} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question31} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question32",
////          "title": "[5.5.2] Overtime work is voluntary and allowed if:\na) It is requested timely. For small farms, requirement only applies if they are hiring:\n- 10 or more temporary workers each working for 3 consecutive months or more, and/or\n- 50 or more temporary workers per calendar year",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question32b",
////          "visibleIf": "{inspection_question32} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question32} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question33",
////          "title": "[5.5.3] Permanent workers are entitled to paid parental leave, rights and benefits in accordance with applicable law. In absence of such law, workers receive paid maternity leave of at least 12 weeks, of which at least six weeks are taken after birth. They can return to their job after maternity leave on the same terms and conditions and without discrimination, loss of seniority or deduction of wages. Workers who are pregnant, nursing or have recently given birth are offered flexible working schedules and work site arrangements. Breastfeeding women have two additional 30-minute breaks per day and an appropriate space for breastfeeding to nurture the child. ",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question33b",
////          "visibleIf": "{inspection_question33} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question33} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question34",
////          "title": "[5.5.4] Do Children of workers who are below the applicable minimum working age and accompanying their parents to the\nworkplace must:\n* Be provided with a safe area appropriate for their age.\n* Be under continuous supervision by adults at all times.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question34b",
////          "visibleIf": "{inspection_question34} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question34} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question35",
////          "title": "[5.6.2] Group members are aware of the availability of first aid and where to receive treatment should the need be",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question35b",
////          "visibleIf": "{inspection_question35} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question35} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question36",
////          "title": "[5.6.3] Do Group members and workers know emergency procedures. Warning signs and safety instructions are clearly\ndisplayed. Workers can leave imminent danger situations without permission or penalty.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question36b",
////          "visibleIf": "{inspection_question36} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question36} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question37",
////          "title": "[5.6.4/5.6.6] Group members' Workers have access to sufficient and safe drinking water at all times",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question37b",
////          "visibleIf": "{inspection_question37} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question37} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question38",
////          "title": "[5.6.8] Workers in hazardous conditions (e.g. Under challenging terrain, with machines or with hazardous materials) use\nPersonal Protective Equipment (PPE) provided for free and receive training on how to use them.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question38b",
////          "visibleIf": "{inspection_question38} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question38} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question39",
////          "title": "[5.6.9] Machinery and other equipment are securely stored when not in use.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question39b",
////          "visibleIf": "{inspection_question39} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question39} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question40",
////          "title": "[5.6.10] Female workers who are pregnant, nursing, or have recently given birth are not assigned to activities that pose a risk\nto their health or the health of their unborn child or infant. In cases of job reassignment, there is no reduction in\nremuneration. Pregnancy tests are not requested.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question40b",
////          "visibleIf": "{inspection_question40} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question40} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question41",
////          "title": "[5.7.3] Workers and their families housed on-site have safe, clean, and decent living conditions that consider local  standards. These include:\n* Safe accommodation in non-hazardous locations, with protection from extreme weather, dry floors, permanent walls, and well-maintained structures.\n* Marked evacuation routes for group accommodations.\n* Protection against air pollution and surface runoff, with adequate sewage, sanitation, and waste disposal facilities.\n* Access to safe drinking water.\n* Adequate sanitary and washing facilities, ensuring the safety and privacy of vulnerable groups through well-lit and lockable facilities",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question41b",
////          "visibleIf": "{inspection_question41} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question41} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question42",
////          "title": "[5.8.2] Do you have a legal or legitimate right to use the land, substantiated by ownership, leasehold, or other legal documents or by documentation of traditional or customary use rights. Verifiable traditional or customary use rights\nmay also be used.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question42b",
////          "visibleIf": "{inspection_question42} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question42} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question43",
////          "title": "[6.1.1] From January 1st, 2014, onward, have you converted natural forests and other natural ecosystems into agricultural production or other land uses?.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question43b",
////          "visibleIf": "{inspection_question43} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question43} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question44",
////          "title": "[6.1.2] Production or processing does not occur in protected areas or their officially designated buffer zones, except where it complies with applicable law.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question44b",
////          "visibleIf": "{inspection_question44} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question44} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question45",
////          "title": "[6.2.2] Farms preserve all remnant forest trees unless they present hazards to people or infrastructure. Other native trees on the farm are managed sustainably to ensure that the same quantity and quality of trees is maintained.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question45b",
////          "visibleIf": "{inspection_question45} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question45} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question46",
////          "title": "[6.2.3/6.2.4] Producers maintain natural vegetation cover. Natural vegetation can include one or more of the following (not exclusive):\n* Riparian buffers\n* Conservation areas within the farm\n* Natural vegetation in agroforestry systems\n* Border plantings, live fences and barriers around housing and infrastructure, or in other ways\n* Conservation and restoration areas outside the certified farm that effectively provide long-term protection of the subject areas ",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question46b",
////          "visibleIf": "{inspection_question46} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question46} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question47",
////          "title": "[6.3.1] Farms maintain existing riparian buffers adjacent to aquatic ecosystems",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question47b",
////          "visibleIf": "{inspection_question47} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question47} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question48",
////          "title": "[6.4.1] Threatened animals and plants are not hunted, killed, fished, collected, or trafficked.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question48b",
////          "visibleIf": "{inspection_question48} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question48} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question49",
////          "title": "[6.4.2] Producers do not keep wildlife in captivity",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question49b",
////          "visibleIf": "{inspection_question49} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question49} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question50",
////          "title": "[6.4.3] Producers avoid intentionally introducing or releasing invasive species.\nProducers do not dispose of existing invasive species or their parts in aquatic ecosystems",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question50b",
////          "visibleIf": "{inspection_question50} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question50} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question51",
////          "title": "[6.4.4] Producers do not use wildlife for processing or harvesting of any crop",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question51b",
////          "visibleIf": "{inspection_question51} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question51} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question52",
////          "title": "[6.4.5] Erosion by water and wind is reduced through practices such as re-vegetation of steep areas and terracing",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question52b",
////          "visibleIf": "{inspection_question52} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question52} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question53",
////          "title": "[6.4.6] Fire is not used for preparing or cleaning fields, except when specifically justified in the IPM plan",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question53b",
////          "visibleIf": "{inspection_question53} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question53} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question54",
////          "title": "[6.5.5] Producers use rainwater harvesting for irrigation and/or other agricultural purposes",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question54b",
////          "visibleIf": "{inspection_question54} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question54} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question55",
////          "title": "[6.5.6] Producers participate in a local watershed committee or initiative and take action to help maintain or restore the watershed’s health as part of this collective process. The nature of the participation and actions taken are documented.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question55b",
////          "visibleIf": "{inspection_question55} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question55} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question56",
////          "title": "[6.6.2] Human sewage, sludge, and sewage water are not used in production or processing",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question56b",
////          "visibleIf": "{inspection_question56} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question56} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question57",
////          "title": "[6.6.3] Wastewater from processing operations is only used on land after treatment to remove particulates and toxins. Treated wastewater for irrigation must meet specific parameters for both wastewater and irrigation",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "N/A"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question57b",
////          "visibleIf": "{inspection_question57} anyof ['No', 'N/A']",
////          "title": "Provide justification.",
////          "requiredIf": "{inspection_question57} anyof ['No', 'N/A']"
////        },
////        {
////          "type": "text",
////          "name": "inspection_question58",
////          "title": "Name of the person present during the inspection",
////          "isRequired": true,
////        },
////        {
////          "type": "panel",
////          "name": "location_panel",
////          "elements": [
////            {
////              "type": "text",
////              "name": "inspection_location",
////              "title": "Geolocation of farm",
////              "isRequired": true,
////              "readOnly": true
////            },
////            {
////              "type": "html",
////              "name": "getInspectionLocation",
////              "html": "<div id='location-container' style='text-align: center;'>\
////              <button id='getInspectionLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button>\</div>"
////            }
////          ]
////        },
////        {
////          "type": "panel",
////          "name": "photo_panel",
////          "title": "Farmer thumbprint",
////          "elements": [
////            {
////              "type": "html",
////              "name": "inspection_photo",
////              "html": "<div id='photo-container' style='text-align: center;'>\
////                <img id='FarmerPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='Farmer Photo'/>\
////                <button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button>\
////              </div>"
////            }
////          ]
////        },
////        {
////          "type": "signaturepad",
////          "name": "signature",
////          "title": "Signature of enumerator",
////          "isRequired": true
////        }
////      ]
////    }
////  ]
////}
//
//
//
//
//
//
//
////const json = {
////  "logoPosition": "right",
////  "pages": [
////    {
////      "name": "page1",
////      "elements": [
////        {
////          "type": "text",
////          "name": "farmer_id",
////          "title": "Farmer ID",
////          "isRequired": true,
////          "readOnly": true
////        },
////        {
////          "type": "text",
////          "name": "farmer_name",
////          "title": "Farmer name",
////          "isRequired": true,
////          "readOnly": true
////        },
////        {
////          "type": "text",
////          "name": "district",
////          "title": "District",
////          "isRequired": true,
////          "readOnly": true
////        },
////        {
////          "type": "text",
////          "name": "community",
////          "title": "Community",
////          "isRequired": true,
////          "readOnly": true
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question1",
////          "title": "[1.2.1] Does management comply with applicable laws and collective bargaining agreements (CBA) within the scope of the Rainforest Alliance Sustainable Agriculture Standard?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question2",
////          "title": "[1.2.6] Do you keep an up-to-date list of permanent and temporary workers, containing records for each worker?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question3",
////          "title": "[1.2.9] Have you kept records for certification purposes and compliance for at least four years?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question4",
////          "title": "[1.2.11] Is a sketch of the farm available, including the production area of certified crop, forests, water bodies, and buildings?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question5",
////          "title": "[2.1.8] Has the farmer kept sales receipts, including the name of a group member, group member ID, date, product type, and volume?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question6",
////          "title": "\"[4.1.1] Does the farmer select plant varieties for planting, grafting, and renovation based on quality, productivity, resistance to pests and diseases, and suitability for the climate during the lifetime of the plants? Are planting materials free of pests and diseases?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question7",
////          "title": "[4.3.1] The certified crop is not genetically modified (GMO)?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question8",
////          "title": "\"[4.4.4] Do you use organic fertilizers and by-products available at the farm level first, and supplement by inorganic fertilizer if nutrients are still lacking? \nTo minimize risk, do you make sure that animal manure is hot composted before use as a fertilizer? Do you store animal manure and compost at least 25 meters away from any water body?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question9",
////          "title": "[4.5.2] Do you regularly monitor pests and their principal natural enemies?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question10",
////          "title": "\"[4.5.3] When threshold levels of pests are reached, do you first try biological, physical, and other non-chemical control methods, and document this? \nWhen such methods are proven not to be effective, do you do agrochemical applications, as advised by a competent technician and/or upon the advice or instruction of an official national organization?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question11",
////          "title": "[4.5.4] Are you and your workers that are involved in pest management activities trained about the IPM strategy?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question12",
////          "title": "\"[4.6.1] Do you ensure that no agrochemicals are used that are:* On the Rainforest Alliance Prohibited List?* Prohibited by applicable law?* Not legally registered in the country where the farm is? located?\nDo you use only agrochemicals sold by authorized vendors, in original and sealed packaging?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question13",
////          "title": "\"[4.6.10] Does the farmer ensure that agrochemicals and application equipment are stored in accordance with the label instructions and in a way that minimizes negative impact on the environment and human health? \nCheck whether agrochemicals are stored in their original containers or packaging\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question14",
////          "title": "\"[4.6.10] Does the farmers facility for storing agrochemicals and equipment meet ALL of the following criteria:* Dry, clean, well-ventilated?* Made from non-absorbent material?* Safely locked and accessible only by trained handlers?* Not accessible to children?* Separated from the crop, food products, and packaging materials?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question15",
////          "title": "[4.6.2] If you use pesticides included on the Risk Mitigation list, do you ensure that all respective risk mitigation practices, as described in Annex 7, Pesticides Management, are implemented?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question16",
////          "title": "\"[4.6.3] Are persons handling pesticides skilled in the preparation and application of pesticides, and receive annual training?\nDo persons handling pesticides use the Personal Protective Equipment (PPE) as prescribed in the products label or Material Safety Data Sheet (MSDS)?\nIf there is no information, do you ensure that basic protective clothing with additional items is worn according to the potential risk and as recommended by a competent technician?\nIs the PPE in good condition?\nDirectly after use, are PPEs washed and stored safely and ensure it does not enter the workers housing?\nAre single-use items disposed of after one use?\nAre PPEs provided to workers free of charge?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question17",
////          "title": "[4.6.4] Do persons handling pesticides bathe, change and wash clothes after application?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question18",
////          "title": "\"[4.6.5] Are pesticides prepared and applied according to the label, MSDS, or security tag, or as recommended by an official national organization or a competent technician, especially with regards to:* Safe transport to the area of application?* Respecting the correct dosage?* Using appropriate equipment and techniques?* appropriate weather conditions?* Respecting restricted entry intervals (REI), including warning signs in the local language?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question19",
////          "title": "[4.6.5] Do you ensure pre-harvest intervals of pesticides as stipulated in the products MSDS, label, security tag, or regulation by the official organization are complied with?  When two or more products with different pre-harvest intervals are used at the same time, the longest interval applies.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question20",
////          "title": "\"[4.6.6] Do you ensure that mechanisms are established and maintained to avoid contamination by pesticides, through spray drift or other pathways, from treated areas to other areas including all aquatic and terrestrial natural ecosystems and infrastructure?\nSuch mechanisms include non-crop vegetative barriers, non-application zones, or other effective mechanisms.\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question21",
////          "title": "[4.6.7] Do you ensure that aerial application is only allowed under the conditions outlined in Annex 7: Pesticides Management?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question22",
////          "title": "\"[4.6.8] Are pesticide applications recorded? \nRecords include:* Product brand name and active ingredient(s)* Date and time of application* Location and area (size) of application* Dosage and volume* Crop* Name(s) of applicator(s)* Target pest\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question23",
////          "title": "\"[4.6.9] Do you ensure that empty pesticide containers and application equipment are washed three times, and rinsing water is used in the last batch of the mix to apply to the crop? Also, do you ensure that, after the application of pesticides, application equipment is washed three times, and the surplus mix is disposed of in a way that minimizes the negative impact on the environment and human health, by diluting it with ten times the amount of clean water and applied evenly on the field that was subjected to the pesticide application?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question24",
////          "title": "\"[4.6.9] Do you ensure that empty pesticide containers are kept in a locked storage area until safely disposed of through a formal collection and recycling program or returned to the supplier? If the supplier does not accept empty containers, are they cut or perforated to prevent other uses?\nDo you ensure that prohibited, obsolete, and expired pesticides are returned to the supplier or local authority? In absence of a collection system in place, are these products labeled and stored safely and separately from other products in the locked space?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question25",
////          "title": "\"[4.7.1] Do you ensure the following: * Are products harvested at the right time and interval to optimize quality?* Are harvesting damages to the plant minimized for future production?* Are contamination by foreign matter, cleaning products and agrochemicals, microbes and pests prevented?* Are damages due to humidity prevented?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question26",
////          "title": "\"[4.7.1] Does the farmer conserve and optimize the quality and quantity of products during harvest and post-harvest handling, including loading, processing, packing, transportation, and storage? \nThis includes:* Products are stored in a cool, dry, well-ventilated, and dark place* Maintenance and cleaning of harvest and postharvest tools, machinery, and equipment* Packaging materials are used that are suitable and approved for food products\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question27",
////          "title": "[5.2.1] Do workers have the right to form and join a union or workers organization of their own choice and to take part in collective bargaining, without prior authorization from the employer, and in accordance with national law? Are workers representatives elected democratically among workers in regular, free elections?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question28",
////          "title": "[5.2.2] Does the Farmer ensure that workers are not subject to discrimination or retaliation for reasons of past or present workers organization or union membership or activities? Management does not punish, bribe, or otherwise influence union members or workers representatives. Records are kept of terminations of employment, including the reason for termination and workers affiliation with a union or workers organization.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question29",
////          "title": "\"[5.2.3] Does management provide workers representatives reasonable paid time off from work to carry out their representation functions and attend meetings?\nWhere needed, management provides the worker representatives with reasonable facilities including meeting space, means of communication, and child care.\nDoes management keep records of the minutes from meetings with worker organizations and/or trade unions from the survey?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question30",
////          "title": "\"[5.3.1] Do you ensure that permanent and temporary workers who are employed for more than three consecutive months have a written employment contract signed by both parties? \nDoes the worker receive a copy of the contract at the time of signing? \nDo permanent and temporary workers employed for fewer than three months have at least verbal contracts in place?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question31",
////          "title": "[5.3.10] Does the farmer also ensure the labor provider is; not engaged in fraudulent or coercive recruiting practices, and is compliant with applicable worker-related requirements? Are all recruitment fees paid by the farm, not by workers?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question32",
////          "title": "[5.3.10] Does the farmer ensure that if labor providers are used, name, contact and, if labor provider is officially registered, official registration number of the labor provider is recorded?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question33",
////          "title": "[5.3.2] Confirm with Farmer that management does not engage in arrangements or practices designed to eliminate or reduce workers pay and/or benefits such as employing temporary workers for permanent or ongoing tasks.",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question34",
////          "title": "\"[5.3.3] Does the farmer ensure that workers receive at least the applicable minimum wage, or the wage negotiated in a Collective Bargaining Agreement (CBA), whichever is higher? \nFor production, quota, or piece work, the payment must be at least the minimum wage based on a 48-hour working week or national legal working hours limit, whichever is lower.\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question35",
////          "title": "[5.3.5] Does Farmer ensure that In-kind benefits are in accordance with national law; however, they cannot exceed 30% of the total remuneration?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question36",
////          "title": "\"[5.3.5] Does the farmer ensure that deductions from wages are permitted only if provided by national law or CBA? \nDoes the farmer also ensure that voluntary wage deductions such as advance payments, union membership, or loans can only be made with written or verbal consent from the worker?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question37",
////          "title": "[5.3.5] Does the farmer ensure that wage deductions as a disciplinary measure are not allowed? Also, do you ensure that deductions for work related to tools, equipment, or gear are not allowed unless those are permitted by law?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question38",
////          "title": "\"[5.3.6] Does the farmer ensure that workers are paid regularly at scheduled intervals agreed upon both by the worker and the employer but must be at least monthly?\nGroup members maintain records, per worker, of hours worked (regular and overtime) and/or volume produced, calculation of wages, in-kind benefits, and deductions. The record is signed by each worker when he/she receives payment.\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question39",
////          "title": "[5.3.8] Does the farmer ensure that work of equal value is remunerated with equal pay without discrimination e.g., on gender or type of worker, ethnicity, age, color, religion, political opinion, nationality, social origin, or others?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question40",
////          "title": "\"[5.5.1] Does the farmer ensure that workers do not work more than eight regular working hours per day and 48 regular working hours per week? In addition, do your workers have at least a 30-minute break after a maximum of six consecutive hours of work and are granted at least one full day of rest after a maximum of six consecutive days of work?\nDo you also ensure that the regular work hours of guards do not exceed 56 hours per week on average per year?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question41",
////          "title": "[5.5.2] Does the farmer ensure that overtime work is voluntary and only permitted if it meets requirements in criterion 5.5.2 of the standard?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question42",
////          "title": "\"[5.5.3] Does the farmer ensure that pregnant permanent workers are entitled to paid maternity leave of at least 14 weeks, of which a maximum of six weeks before the expected due date and at least six weeks after giving birth, and receive maternity rights and benefits?\nDo breastfeeding women have two additional 30-minute breaks per day and a space for breastfeeding to nurture the child?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question43",
////          "title": "\"[5.5.4] Do you ensure that workers children younger than the applicable minimum working age who come with their parents to the workplace:* Are provided with a safe place to stay according to their age?* Are always under the supervision of adults?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question44",
////          "title": "\"[5.6.10] Are all tools used by the workers in good working condition?\nDo machines have clear instructions on safe usage that can be understood by the workers and are dangerous parts guarded or encased?\nAre workers using such machines appropriately trained?\nDo you have applicable licenses for your operating machinery?\nDo you safely store machinery and other equipment when not in use?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question45",
////          "title": "\"[5.6.11] Do you ensure female workers who are pregnant, nursing, or have recently given birth are not assigned to activities that pose a risk to the womans, unborn children, or infants health? In cases of job reassignment, do you ensure there is no reduction in remuneration?\nDo you ensure not to request pregnancy tests?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question46",
////          "title": "[5.6.12] Are your workers allowed to leave situations with imminent danger without seeking your permission?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question47",
////          "title": "\"[5.6.2] Are First aid boxes available to workers for the treatment of work-related injuries?\nThe boxes are placed at the central locations of production, processing, and maintenance sites. Trained first aid employees are present during working hours. The workers are informed where, and to whom they should go for first aid in case of emergency.\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question48",
////          "title": "[5.6.3] Do the farmer and workers know where to go in case of an emergency?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question49",
////          "title": "[5.6.6] Do workers always have access to safe and sufficient drinking water?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question50",
////          "title": "\"[5.6.9] Do persons that work in hazardous situations (e.g., under challenging terrains, with machines, or with hazardous materials) use appropriate Personal Protective Equipment (PPE)?\nAre these persons trained in the use of the PPE and have access to the PPE free of charge?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question51",
////          "title": "\"[5.7.3] Do the workers and their families that are housed or lodged on-site have safe, clean, and decent living quarters considering local conditions and the possibilities of each producer?* Access to safe drinking water* Adequate sanitary and washing facilities. Safety and privacy of vulnerable groups are ensured, at least by well-lit and lockable facilities\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No",
////            "NA"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question52",
////          "title": "\"[5.8.2] Does the producer have a legal and legitimate right to use the land? In case of a dispute involving indigenous people and local communities, large farms and individually certified farms follow an FPIC process in accordance with the Rainforest Alliance FPIC Annex to attain the required conflict resolution and remediation.\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question53",
////          "title": "[6.1.1] From January 1st, 2014 onward, have you ensured that natural forests and other natural ecosystems have not been converted into agricultural production or other land uses?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question54",
////          "title": "[6.1.2] Do you ensure that production or processing does not occur in protected areas or their officially designated buffer zones, except where it complies with applicable law?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question55",
////          "title": "[6.2.2] Do you maintain all remnant forest trees, except when these pose hazards to people or infrastructure on your farm? Do you sustainably manage other native trees on the farm and their harvesting in a way that the same quantity and quality of trees are maintained on the farm?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question56",
////          "title": "[6.3.1] Do you maintain existing riparian buffers adjacent to aquatic ecosystems on your farm?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question57",
////          "title": "[6.3.2] Do you maintain the additional safeguards for the protection of drinking water in case the farm is located closer than 50 m to a source of drinking water?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question58",
////          "title": "\"[6.4.1] Do you ensure not to hunt, kill, fish, collect or traffick threatened animals and plants?\nAlso, do you ensure not to hunt other animals, with the following exceptions:* Producers of small farms may hunt non-threatened animals for non-commercial use only* Producers may hunt vertebrate wildlife pests on the farm only following the farms integrated\npest management (IPM) plan, and only as a measure of last resort.\nDo you ensure not to use explosives or toxic substances for hunting, fishing, or control of wildlife pests?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question59",
////          "title": "\"[6.4.2] Do you ensure not to hold wildlife in captivity? \nDo you send captive wild animals that were present on the farm before the earliest certification date to professional shelters or may be held only for non-commercial purposes for the remainder of their lives? \nCaptive wild animals and farm animals are treated following the five freedom of animal welfare.\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question60",
////          "title": "[6.4.3] Do you ensure not to intentionally introduce or release invasive species? Do you also ensure not to dispose of existing invasive species or their parts in aquatic ecosystems?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question61",
////          "title": "[6.4.4] Do you make sure not to use wildlife for processing or harvesting any crop?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question62",
////          "title": "[6.4.5] Do you prevent/reduce erosion by water and wind through practices such as re-vegetation of steep areas and terracing?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question63",
////          "title": "[6.4.6] Do you make sure not to use fire for preparing or cleaning fields, except when specifically justified in the IPM plan?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question64",
////          "title": "[6.6.2] Do you ensure not to use human sewage, sludge, and sewage water for production and/or processing activities?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question65",
////          "title": "\"[6.6.3] Do you ensure that wastewater from processing operations is not applied to land unless it has undergone treatment to remove particulates and toxins?\nIf treated wastewater is used for irrigation, in addition to the wastewater parameters, it must comply with the wastewater parameters for irrigation.\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question66",
////          "title": "\"[6.7.1] Do you ensure that waste is stored, treated, and disposed of in ways that do not pose health or safety risks to people, animals, or natural ecosystems?\nDo you also ensure that waste is stored and disposed of only in designated areas and not disposed of in natural or aquatic ecosystems? \nAre non-organic waste left on the land?\"",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "dropdown",
////          "name": "inspection_question67",
////          "title": "[6.7.2] Do you ensure that you do not burn waste, except in incinerators technically designed for the specific type of waste?",
////          "isRequired": true,
////          "choices": [
////            "Yes",
////            "No"
////          ]
////        },
////        {
////          "type": "text",
////          "name": "inspection_question68",
////          "title": "Name of the person present during the inspection",
////          "isRequired": true,
////        },
////        {
////          "type": "panel",
////          "name": "location_panel",
////          "elements": [
////            {
////              "type": "text",
////              "name": "inspection_location",
////              "title": "Geolocation of farm",
////              "isRequired": true,
////              "readOnly": true
////            },
////            {
////              "type": "html",
////              "name": "getInspectionLocation",
////              "html": "<div id='location-container' style='text-align: center;'>\
////              <button id='getInspectionLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button>\</div>"
////            }
////          ]
////        },
////        {
////          "type": "panel",
////          "name": "photo_panel",
////          "title": "Farmer thumbprint",
////          "elements": [
////            {
////              "type": "html",
////              "name": "inspection_photo",
////              "html": "<div id='photo-container' style='text-align: center;'>\
////                <img id='FarmerPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='Farmer Photo'/>\
////                <button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button>\
////              </div>"
////            }
////          ]
////        },
////        {
////          "type": "signaturepad",
////          "name": "signature",
////          "title": "Signature of enumerator",
////          "isRequired": true
////        }
////      ]
////    }
////  ]
////}