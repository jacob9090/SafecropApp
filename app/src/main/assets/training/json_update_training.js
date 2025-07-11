const json = {
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "text",
          "name": "farmer_id",
          "title": "Farmer ID"
        },
        {
          "type": "text",
          "name": "farmer_name",
          "title": "Farmer Name"
        },
        {
          "type": "text",
          "name": "gender",
          "title": "Gender"
        },
        {
          "type": "text",
          "name": "district",
          "title": "District"
        },
        {
          "type": "text",
          "name": "community",
          "title": "Community"
        },
        {
          "type": "text",
          "name": "plot_id",
          "title": "Plot ID"
        },
        {
          "type": "dropdown",
          "name": "inspection_question1",
          "title": "[BS 1.2.1] Producer is aware and comply with applicable laws relevant to the scope of the Rainforest Alliance Standard. Including but not limited to:\n*Land use right\n*Environment\n*Labor\n*Human rights\n*FPIC\n*Taxes and anti-corruption issues",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question1b",
          "visibleIf": "{inspection_question1} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question1} = 'Yes'",
          "requiredIf": "{inspection_question1} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question2",
          "title": "[1.2.5] For permanent workers, up-to-date records are kept, containing, for each worker:\n* Full name\n* Gender\n* Year of birth\n* Wages, including benefits\nFor temporary workers, only the number of workers is required.\nIlliterate group members can give the above information orally",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question2b",
          "visibleIf": "{inspection_question2} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question2} = 'Yes'",
          "requiredIf": "{inspection_question2} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question3",
          "title": "[1.2.7] Farmer has a copy of contract and understands the content of contract signed",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question3b",
          "visibleIf": "{inspection_question3} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question3} = 'Yes'",
          "requiredIf": "{inspection_question3} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question4",
          "title": "[1.2.8]  Records for certification purposes and compliance are kept for a minimum of five years.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question4b",
          "visibleIf": "{inspection_question4} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question4} = 'Yes'",
          "requiredIf": "{inspection_question4} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question5",
          "title": "[1.5.1] Farmer knows the grievance mechanism and understands the system in place",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question5b",
          "visibleIf": "{inspection_question5} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question5} = 'Yes'",
          "requiredIf": "{inspection_question5} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question6",
          "title": "[2.1.8] Do you keep sales receipts (electronic or physical), including name of group member, group member ID,date, product type, and volume.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question6b",
          "visibleIf": "{inspection_question6} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question6} = 'Yes'",
          "requiredIf": "{inspection_question6} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question7",
          "title": "[3.1.3] Farmer has received premium and receipt of premium is available.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question7b",
          "visibleIf": "{inspection_question7} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question7} = 'Yes'",
          "requiredIf": "{inspection_question7} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question8",
          "title": "[4.1.1] Are your Plant varieties (planting, grafting and renovation) selected based on quality, productivity, resistance to pests and diseases and on suitability for the climate during the lifetime of the plants.\nPlanting materials are free of pests and diseases",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question8b",
          "visibleIf": "{inspection_question8} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question8} = 'Yes'",
          "requiredIf": "{inspection_question8} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question9",
          "title": "[4.1.2] For new plantings, Do you follow a well-established cropping system that considers various factors, including:\n* Requirements of the variety used\n* Geographical, ecological, and agronomic conditions\n* Diversification and intercropping crops with different rooting depths and soil uses to enhance soil quality and\nhealth\n* Planting density",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question9b",
          "visibleIf": "{inspection_question9} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question9} = 'Yes'",
          "requiredIf": "{inspection_question9} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question10",
          "title": "[4.1.3] Based on IPM strategy, Do you implement measures to prevent pests and diseases and to break their biological\ncycles, to support soil health and to improve weed management. Such measures can include intercropping, and\nmeasures taken in between crop cycles, such as crop rotation or leaving the land fallow.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question10b",
          "visibleIf": "{inspection_question10} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question10} = 'Yes'",
          "requiredIf": "{inspection_question10} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question11",
          "title": "[4.2.1] Do you implement a pruning cycle for the formation, maintenance, and rejuvenation of crops according to their\nneeds, agroecological conditions, and applicable pruning guidelines.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question11b",
          "visibleIf": "{inspection_question11} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question11} = 'Yes'",
          "requiredIf": "{inspection_question11} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question12",
          "title": "[4.3.1] The certified crop is not genetically modified (GMO)",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question12b",
          "visibleIf": "{inspection_question12} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question12} = 'Yes'",
          "requiredIf": "{inspection_question12} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question13",
          "title": "[4.4.3] Do you prioritize the use of farm-made organic fertilizers. If additional nutrients are needed, they supplement with other organic or inorganic fertilizers. Animal manure is hot composted to reduce risk and stored at least 25 meters from water bodies",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question13b",
          "visibleIf": "{inspection_question13} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question13} = 'Yes'",
          "requiredIf": "{inspection_question13} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question14",
          "title": "[4.6.1] Do you use agrochemicals that are:\n* On the Rainforest Alliance List of Prohibited Pesticides or List of Obsolete Pesticides\n* Prohibited by applicable law\n* Not legally registered in the country where the farm is located\nProducers use only agrochemicals sold by authorized vendors, in original and sealed packaging.\nChemical substances used for livestock or pets are not included in the scope of this standard",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question14b",
          "visibleIf": "{inspection_question14} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question14} = 'Yes'",
          "requiredIf": "{inspection_question14} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question15",
          "title": "[4.6.2] Do you implement all relevant practices described in the farming annex if pesticides used are on the Risk mitigation list? Do you use the  pesticides under the Exceptional Use Policy must follow all respective practices detailed in this policy and adhere to the procedure for requesting and reporting exceptions as outlined in the annex.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question15b",
          "visibleIf": "{inspection_question15} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question15} = 'Yes'",
          "requiredIf": "{inspection_question15} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question16",
          "title": "[4.6.3 1] Do you handle or apply agrochemicals (e.g., pesticides) on your farm? \n2. If yes, have you received training on how to prepare and apply these chemicals safely, including the use of protective equipment?                                                                            ",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question16b",
          "visibleIf": "{inspection_question16} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question16} = 'Yes'",
          "requiredIf": "{inspection_question16} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question17",
          "title": "[4.6.4] Do Pesticide handlers bathe, change, and wash clothes after application. Management should provide them with a private area, water, soap, and, if possible, bathing facilities",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question17b",
          "visibleIf": "{inspection_question17} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question17} = 'Yes'",
          "requiredIf": "{inspection_question17} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question18",
          "title": "[4.6.5] Are Pesticides prepared and applied according to the label, MSDS or security tag, or as recommended by an official\nnational organization or a competent technician, especially with regards to:\n* Safe transport to area of application\n* Respecting the correct dosage\n* Using appropriate equipment and techniques\n* Appropriate weather conditions\n* Respecting restricted entry intervals (REI), including warning signs in local language and informing potentially\naffected persons or communities in advance. Pre-harvest intervals are respected as well",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question18b",
          "visibleIf": "{inspection_question18} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question18} = 'Yes'",
          "requiredIf": "{inspection_question18} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question19",
          "title": "[4.6.6] Mechanisms are in place to prevent contamination by pesticides, through spray drift or other means, from treated areas to other areas including all aquatic and terrestrial ecosystems and infrastructure. These mechanisms include non-crop vegetative barriers, non-application zones, or other effective measures",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question19b",
          "visibleIf": "{inspection_question19} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question19} = 'Yes'",
          "requiredIf": "{inspection_question19} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question20",
          "title": "[4.6.7] Aerial application is only allowed under the conditions as outlined in the Farming Annex",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question20b",
          "visibleIf": "{inspection_question20} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question20} = 'Yes'",
          "requiredIf": "{inspection_question20} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question21",
          "title": "[4.6.8] Pesticide applications are recorded. Records include:\n* Product brand name and active ingredient(s)\n* Date and time of application\n* Location and area (size) of application\n* Dosage and volume (organic or inorganic)\n* Crop\n* Name(s) of applicator(s)\n* Target pest",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question21b",
          "visibleIf": "{inspection_question21} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question21} = 'Yes'",
          "requiredIf": "{inspection_question21} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question22",
          "title": "[4.6.9] Empty pesticide containers and application equipment are washed three times, with the rinsing water used in the final batch of the mix for crop application. After applying pesticides, application equipment is washed three times, and any leftover mix is diluted with ten times the amount of clean water and applied evenly on the treated field to minimize environmental and health impacts. Empty pesticide containers are stored securely until they can be disposed of safely. Prohibited, obsolete, and expired pesticides are returned to the supplier or local authority or labeled and stored safely and separately from other products in a locked space",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question22b",
          "visibleIf": "{inspection_question22} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question22} = 'Yes'",
          "requiredIf": "{inspection_question22} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question23",
          "title": "[4.6.10] Agrochemicals and application equipment are stored in accordance with label instructions to ensure minimal negative impact on the environment and human health. Agrochemicals must remain in their original containers or packaging.\nFacilities for storing agrochemicals and application equipment should be:\n* Dry, clean, and well-ventilated\n* Constructed from non-absorbent materials\n* Securely locked and accessible only by trained handlers\n* Inaccessible to children\n* Separated from crops, food products, and packaging materials",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question23b",
          "visibleIf": "{inspection_question23} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question23} = 'Yes'",
          "requiredIf": "{inspection_question23} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question24",
          "title": "[4.7.1] Do you handle cocoa in a manner to maintain quality and quantity during harvest and post-harvest stages, such as loading, processing, packing, transportation, and storage. This includes:\n* Harvesting products at the right time to optimize quality\n* Minimizing plant damage for future production\n* Preventing contamination from foreign matter, cleaning products, agrochemicals, microbes, and pests\n* Avoiding moisture damage\n* Storing products in a cool, dry, dark, and well-ventilated place\n* Maintaining and cleaning tools, machinery, and equipment used in harvest and post-harvest\n* Using suitable and approved packaging materials for food products",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question24b",
          "visibleIf": "{inspection_question24} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question24} = 'Yes'",
          "requiredIf": "{inspection_question24} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question25",
          "title": "[5.2.1] Workers can form and join unions or workers' organizations of their choice and participate in collective bargaining\nwithout employer approval, as per applicable law. Workers’ representatives are elected democratically in regular\nfree and fair elections. For small farms, the requirement only applies if they are hiring:\n- 10 or more temporary workers each working for three consecutive months or more, and/or\n- 50 or more temporary workers per calendar year",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question25b",
          "visibleIf": "{inspection_question25} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question25} = 'Yes'",
          "requiredIf": "{inspection_question25} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question26",
          "title": "[5.2.2] Workers are protected from discrimination or retaliation due to union activities. Management cannot punish, bribe,\nor influence union members or representatives. For small farms, the requirement only applies if they are hiring:\n- 10 or more temporary workers each working for three consecutive months or more, and/or\n- 50 or more temporary workers per calendar year",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question26b",
          "visibleIf": "{inspection_question26} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question26} = 'Yes'",
          "requiredIf": "{inspection_question26} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question27",
          "title": "[5.3.1] Workers employed for 3 consecutive months or more must have a written contract signed by both parties. Those\nemployed for less than 3 months must have at least a verbal contract, with the employer keeping records of these\ncontracts. Written contracts for workers employed 3 consecutive months or more include:\n* Job duties\n* Job location\n* Working hours\n* Pay rate/method of calculation\n* Overtime pay rate\n*Payment schedule\n* Deductions and benefits\n* Paid leave\n* Medical leave and protections for illness, disability, or accident\n* Notice period for termination\nVerbal contract records include:\n* Working hours\n* Pay rate\n* Overtime pay\nAll workers understand their employment contracts before starting work and can request a copy anytime.\nFor small farms, the requirement only applies if they are hiring:\n- 10 or more temporary workers each working for three consecutive months or more, and/or\n- 50 or more temporary workers per calendar year.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question27b",
          "visibleIf": "{inspection_question27} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question27} = 'Yes'",
          "requiredIf": "{inspection_question27} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question28",
          "title": "[5.3.2] There are no policies and/or arrangements to reduce workers' pay or benefits, such as using temporary workers for\npermanent tasks.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question28b",
          "visibleIf": "{inspection_question28} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question28} = 'Yes'",
          "requiredIf": "{inspection_question28} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question29",
          "title": "[5.3.3] Do producers and management adhere to collective bargaining agreements (CBA) relevant to the Rainforest Alliance Standard.\nWorkers are paid at least the applicable minimum wage or the wage stipulated in a CBA, whichever is higher. For production quota or piece work, the payment must meet at least the minimum wage, based on a 48-hour working week or the national legal working hours limit, whichever is lower.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question29b",
          "visibleIf": "{inspection_question29} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question29} = 'Yes'",
          "requiredIf": "{inspection_question29} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question30",
          "title": "[5.3.4] Deductions from wages for social security are only allowed if specified by applicable law or CBA. Voluntary deductions, like advance payments or loans, require worker consent. Employers must handle these remittances fully and in a timely manner. Disciplinary wage deductions are prohibited. Deductions for tools or gear are not allowed unless legally permitted. In-kind benefits must comply with the law and cannot exceed 30% of total pay",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question30b",
          "visibleIf": "{inspection_question30} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question30} = 'Yes'",
          "requiredIf": "{inspection_question30} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question31",
          "title": "[5.3.5] Do Workers receive payments at regular intervals as agreed upon by both the worker and the employer",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question31b",
          "visibleIf": "{inspection_question31} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question31} = 'Yes'",
          "requiredIf": "{inspection_question31} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question32",
          "title": "[5.3.6] Work of equal value receives equal remuneration, free from discrimination on grounds such as gender, worker type,\nethnicity, age, color, religion, political opinion, nationality, social origin, or other factors",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question32b",
          "visibleIf": "{inspection_question32} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question32} = 'Yes'",
          "requiredIf": "{inspection_question32} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question33",
          "title": "[5.3.7] If labor providers are used, records are kept including the name, contact details and official registration number (if\navailable).\nThe labor provider is:\n* Not engaged in fraudulent or coercive recruiting practices.\n* Compliant with applicable worker-related requirements 5.3 and 5.5 of this standard.\nAll recruitment fees are paid by the farm, not by workers.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question33b",
          "visibleIf": "{inspection_question33} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question33} = 'Yes'",
          "requiredIf": "{inspection_question33} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question34",
          "title": "[5.5.1] Workers do not exceed eight regular working hours per day or 48 hours per week. They receive a 30-minute break\nafter six consecutive hours and one full rest day after six consecutive working days. Guards do not exceed 60 hours\nper week or the applicable regulation, whichever is stricter.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question34b",
          "visibleIf": "{inspection_question34} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question34} = 'Yes'",
          "requiredIf": "{inspection_question34} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question35",
          "title": "[5.5.2] Overtime work is voluntary and allowed if:\na) It is requested timely. For small farms, requirement only applies if they are hiring:\n- 10 or more temporary workers each working for 3 consecutive months or more, and/or\n- 50 or more temporary workers per calendar year",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question35b",
          "visibleIf": "{inspection_question35} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question35} = 'Yes'",
          "requiredIf": "{inspection_question35} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question36",
          "title": "[5.5.3] Permanent workers are entitled to paid parental leave, rights and benefits in accordance with applicable law. In absence of such law, workers receive paid maternity leave of at least 12 weeks, of which at least six weeks are taken after birth. They can return to their job after maternity leave on the same terms and conditions and without discrimination, loss of seniority or deduction of wages. Workers who are pregnant, nursing or have recently given birth are offered flexible working schedules and work site arrangements. Breastfeeding women have two additional 30-minute breaks per day and an appropriate space for breastfeeding to nurture the child. ",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question36b",
          "visibleIf": "{inspection_question36} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question36} = 'Yes'",
          "requiredIf": "{inspection_question36} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question37",
          "title": "[5.5.4] Do Children of workers who are below the applicable minimum working age and accompanying their parents to the\nworkplace must:\n* Be provided with a safe area appropriate for their age.\n* Be under continuous supervision by adults at all times.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question37b",
          "visibleIf": "{inspection_question37} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question37} = 'Yes'",
          "requiredIf": "{inspection_question37} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question38",
          "title": "[5.6.2] Group members are aware of the availability of first aid and where to receive treatment should the need be",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question38b",
          "visibleIf": "{inspection_question38} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question38} = 'Yes'",
          "requiredIf": "{inspection_question38} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question39",
          "title": "[5.6.3] Do Group members and workers know emergency procedures. Warning signs and safety instructions are clearly\ndisplayed. Workers can leave imminent danger situations without permission or penalty.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question39b",
          "visibleIf": "{inspection_question39} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question39} = 'Yes'",
          "requiredIf": "{inspection_question39} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question40",
          "title": "[5.6.4/5.6.6] Group members' Workers have access to sufficient and safe drinking water at all times",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question40b",
          "visibleIf": "{inspection_question40} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question40} = 'Yes'",
          "requiredIf": "{inspection_question40} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question41",
          "title": "[5.6.8] Workers in hazardous conditions (e.g. Under challenging terrain, with machines or with hazardous materials) use\nPersonal Protective Equipment (PPE) provided for free and receive training on how to use them.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question41b",
          "visibleIf": "{inspection_question41} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question41} = 'Yes'",
          "requiredIf": "{inspection_question41} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question42",
          "title": "[5.6.9] Machinery and other equipment are securely stored when not in use.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question42b",
          "visibleIf": "{inspection_question42} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question42} = 'Yes'",
          "requiredIf": "{inspection_question42} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question43",
          "title": "[5.6.10] Female workers who are pregnant, nursing, or have recently given birth are not assigned to activities that pose a risk\nto their health or the health of their unborn child or infant. In cases of job reassignment, there is no reduction in\nremuneration. Pregnancy tests are not requested.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question43b",
          "visibleIf": "{inspection_question43} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question43} = 'Yes'",
          "requiredIf": "{inspection_question43} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question44",
          "title": "[5.7.3] Workers and their families housed on-site have safe, clean, and decent living conditions that consider local  standards. These include:\n* Safe accommodation in non-hazardous locations, with protection from extreme weather, dry floors, permanent walls, and well-maintained structures.\n* Marked evacuation routes for group accommodations.\n* Protection against air pollution and surface runoff, with adequate sewage, sanitation, and waste disposal facilities.\n* Access to safe drinking water.\n* Adequate sanitary and washing facilities, ensuring the safety and privacy of vulnerable groups through well-lit and lockable facilities",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question44b",
          "visibleIf": "{inspection_question44} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question44} = 'Yes'",
          "requiredIf": "{inspection_question44} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question45",
          "title": "[5.8.2] Do you have a legal or legitimate right to use the land, substantiated by ownership, leasehold, or other legal documents or by documentation of traditional or customary use rights. Verifiable traditional or customary use rights\nmay also be used.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question45b",
          "visibleIf": "{inspection_question45} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question45} = 'Yes'",
          "requiredIf": "{inspection_question45} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question46",
          "title": "[6.1.1] From January 1st, 2014, onward, have you converted natural forests and other natural ecosystems into agricultural production or other land uses?.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question46b",
          "visibleIf": "{inspection_question46} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question46} = 'Yes'",
          "requiredIf": "{inspection_question46} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question47",
          "title": "[6.1.2] Production or processing does not occur in protected areas or their officially designated buffer zones, except where it complies with applicable law.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question47b",
          "visibleIf": "{inspection_question47} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question47} = 'Yes'",
          "requiredIf": "{inspection_question47} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question48",
          "title": "[6.2.2] Farms preserve all remnant forest trees unless they present hazards to people or infrastructure. Other native trees on the farm are managed sustainably to ensure that the same quantity and quality of trees is maintained.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question48b",
          "visibleIf": "{inspection_question48} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question48} = 'Yes'",
          "requiredIf": "{inspection_question48} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question49",
          "title": "[6.2.3/6.2.4] Producers maintain natural vegetation cover. Natural vegetation can include one or more of the following (not exclusive):\n* Riparian buffers\n* Conservation areas within the farm\n* Natural vegetation in agroforestry systems\n* Border plantings, live fences and barriers around housing and infrastructure, or in other ways\n* Conservation and restoration areas outside the certified farm that effectively provide long-term protection of the subject areas ",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question49b",
          "visibleIf": "{inspection_question49} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question49} = 'Yes'",
          "requiredIf": "{inspection_question49} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question50",
          "title": "[6.3.1] Farms maintain existing riparian buffers adjacent to aquatic ecosystems",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question50b",
          "visibleIf": "{inspection_question50} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question50} = 'Yes'",
          "requiredIf": "{inspection_question50} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question51",
          "title": "[6.3.2] Producers maintain the following additional safeguards for the protection of drinking water in case the farm is \nlocated closer than 50m from a river, lake, or other water body that is frequently used as the main source of drinking. \n• Maintain or establish a riparian buffer that is at least 10m wide \n• Add an outer, additional 20m non-application zone (total 30m) where no pesticides or fertilizers are used \n• Add an additional 20m zone (from 30 to 50m from the waterbody), in which pesticides are only applied \nthrough mechanical, hand-assisted or targeted application ",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question51b",
          "visibleIf": "{inspection_question51} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question51} = 'Yes'",
          "requiredIf": "{inspection_question51} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question52",
          "title": "[6.4.1] Threatened animals and plants are not hunted, killed, fished, collected, or trafficked.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question52b",
          "visibleIf": "{inspection_question52} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question52} = 'Yes'",
          "requiredIf": "{inspection_question52} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question53",
          "title": "[6.4.2] Producers do not keep wildlife in captivity",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question53b",
          "visibleIf": "{inspection_question53} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question53} = 'Yes'",
          "requiredIf": "{inspection_question53} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question54",
          "title": "[6.4.3] Producers avoid intentionally introducing or releasing invasive species.\nProducers do not dispose of existing invasive species or their parts in aquatic ecosystems",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question54b",
          "visibleIf": "{inspection_question54} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question54} = 'Yes'",
          "requiredIf": "{inspection_question54} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question55",
          "title": "[6.4.4] Producers do not use wildlife for processing or harvesting of any crop",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question55b",
          "visibleIf": "{inspection_question55} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question55} = 'Yes'",
          "requiredIf": "{inspection_question55} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question56",
          "title": "[6.4.5] Erosion by water and wind is reduced through practices such as re-vegetation of steep areas and terracing",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question56b",
          "visibleIf": "{inspection_question56} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question56} = 'Yes'",
          "requiredIf": "{inspection_question56} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question57",
          "title": "[6.4.6] Fire is not used for preparing or cleaning fields, except when specifically justified in the IPM plan",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question57b",
          "visibleIf": "{inspection_question57} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question57} = 'Yes'",
          "requiredIf": "{inspection_question57} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question58",
          "title": "[6.5.5] Producers use rainwater harvesting for irrigation and/or other agricultural purposes",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question58b",
          "visibleIf": "{inspection_question58} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question58} = 'Yes'",
          "requiredIf": "{inspection_question58} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question59",
          "title": "[6.5.6] Producers participate in a local watershed committee or initiative and take action to help maintain or restore the watershed’s health as part of this collective process. The nature of the participation and actions taken are documented.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question59b",
          "visibleIf": "{inspection_question59} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question59} = 'Yes'",
          "requiredIf": "{inspection_question59} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question60",
          "title": "[6.6.2] Human sewage, sludge, and sewage water are not used in production or processing",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question60b",
          "visibleIf": "{inspection_question60} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question60} = 'Yes'",
          "requiredIf": "{inspection_question60} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question61",
          "title": "[6.6.3] Wastewater from processing operations is only used on land after treatment to remove particulates and toxins. Treated wastewater for irrigation must meet specific parameters for both wastewater and irrigation",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question61b",
          "visibleIf": "{inspection_question61} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question61} = 'Yes'",
          "requiredIf": "{inspection_question61} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question62",
          "title": "[6.7.1] Waste is managed to avoid health and safety risks. It is stored and disposed of only in designated areas, not in \nnatural ecosystems. Non-organic waste is not left on land.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question62b",
          "visibleIf": "{inspection_question62} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question62} = 'Yes'",
          "requiredIf": "{inspection_question62} anyof ['No', 'N/A']"
        },
        {
          "type": "dropdown",
          "name": "inspection_question63",
          "title": "[6.7.2] Producers do not burn waste, except in incinerators technically designed for the specific type of waste.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "N/A"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question63b",
          "visibleIf": "{inspection_question63} anyof ['No', 'N/A']",
          "title": "Provide justification.",
          "resetValueIf": "{inspection_question63} = 'Yes'",
          "requiredIf": "{inspection_question63} anyof ['No', 'N/A']"
        },
        {
          "type": "text",
          "name": "inspection_question64",
          "title": "Name of the person present during the inspection",
          "isRequired": true
        },
        {
          "type": "panel",
          "name": "location_panel",
          "elements": [
            {
              "type": "text",
              "name": "inspection_location",
              "title": "Geolocation of farm",
              "isRequired": true,
              "readOnly": true
            },
            {
              "type": "html",
              "name": "getInspectionLocation",
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
              "name": "inspection_photo",
              "html": "<div id='photo-container' style='text-align: center;'><img id='FarmerPhotoDisplay' src='file:///android_asset/imgs/cam.png' style='width: 50%; height: auto;' alt='Farmer Photo'/><button id='getFarmerPhoto' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetFarmerPhoto()'>Get Photo</button></div>"
            }
          ]
        },
        {
          "type": "signaturepad",
          "name": "signature",
          "title": "Signature of enumerator",
          "isRequired": true
        }
      ]
    }
  ]
}