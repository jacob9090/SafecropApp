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
          "isRequired": true,
          "readOnly": true
        },
        {
          "type": "text",
          "name": "farmer_name",
          "title": "Farmer name",
          "isRequired": true,
          "readOnly": true
        },
        {
          "type": "text",
          "name": "district",
          "title": "District",
          "isRequired": true,
          "readOnly": true
        },
        {
          "type": "text",
          "name": "community",
          "title": "Community",
          "isRequired": true,
          "readOnly": true
        },
        {
          "type": "dropdown",
          "name": "inspection_question1",
          "title": "[1.2.1] Does management comply with applicable laws and collective bargaining agreements (CBA) within the scope of the Rainforest Alliance Sustainable Agriculture Standard?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question2",
          "title": "[1.2.6] Do you keep an up-to-date list of permanent and temporary workers, containing records for each worker?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question3",
          "title": "[1.2.9] Have you kept records for certification purposes and compliance for at least four years?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question4",
          "title": "[1.2.11] Is a sketch of the farm available, including the production area of certified crop, forests, water bodies, and buildings?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question5",
          "title": "[2.1.8] Has the farmer kept sales receipts, including the name of a group member, group member ID, date, product type, and volume?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question6",
          "title": "\"[4.1.1] Does the farmer select plant varieties for planting, grafting, and renovation based on quality, productivity, resistance to pests and diseases, and suitability for the climate during the lifetime of the plants? Are planting materials free of pests and diseases?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question7",
          "title": "[4.3.1] The certified crop is not genetically modified (GMO)?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question8",
          "title": "\"[4.4.4] Do you use organic fertilizers and by-products available at the farm level first, and supplement by inorganic fertilizer if nutrients are still lacking? \nTo minimize risk, do you make sure that animal manure is hot composted before use as a fertilizer? Do you store animal manure and compost at least 25 meters away from any water body?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question9",
          "title": "[4.5.2] Do you regularly monitor pests and their principal natural enemies?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question10",
          "title": "\"[4.5.3] When threshold levels of pests are reached, do you first try biological, physical, and other non-chemical control methods, and document this? \nWhen such methods are proven not to be effective, do you do agrochemical applications, as advised by a competent technician and/or upon the advice or instruction of an official national organization?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question11",
          "title": "[4.5.4] Are you and your workers that are involved in pest management activities trained about the IPM strategy?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question12",
          "title": "\"[4.6.1] Do you ensure that no agrochemicals are used that are:* On the Rainforest Alliance Prohibited List?* Prohibited by applicable law?* Not legally registered in the country where the farm is? located?\nDo you use only agrochemicals sold by authorized vendors, in original and sealed packaging?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question13",
          "title": "\"[4.6.10] Does the farmer ensure that agrochemicals and application equipment are stored in accordance with the label instructions and in a way that minimizes negative impact on the environment and human health? \nCheck whether agrochemicals are stored in their original containers or packaging\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question14",
          "title": "\"[4.6.10] Does the farmers facility for storing agrochemicals and equipment meet ALL of the following criteria:* Dry, clean, well-ventilated?* Made from non-absorbent material?* Safely locked and accessible only by trained handlers?* Not accessible to children?* Separated from the crop, food products, and packaging materials?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question15",
          "title": "[4.6.2] If you use pesticides included on the Risk Mitigation list, do you ensure that all respective risk mitigation practices, as described in Annex 7, Pesticides Management, are implemented?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question16",
          "title": "\"[4.6.3] Are persons handling pesticides skilled in the preparation and application of pesticides, and receive annual training?\nDo persons handling pesticides use the Personal Protective Equipment (PPE) as prescribed in the products label or Material Safety Data Sheet (MSDS)?\nIf there is no information, do you ensure that basic protective clothing with additional items is worn according to the potential risk and as recommended by a competent technician?\nIs the PPE in good condition?\nDirectly after use, are PPEs washed and stored safely and ensure it does not enter the workers housing?\nAre single-use items disposed of after one use?\nAre PPEs provided to workers free of charge?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question17",
          "title": "[4.6.4] Do persons handling pesticides bathe, change and wash clothes after application?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question18",
          "title": "\"[4.6.5] Are pesticides prepared and applied according to the label, MSDS, or security tag, or as recommended by an official national organization or a competent technician, especially with regards to:* Safe transport to the area of application?* Respecting the correct dosage?* Using appropriate equipment and techniques?* appropriate weather conditions?* Respecting restricted entry intervals (REI), including warning signs in the local language?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question19",
          "title": "[4.6.5] Do you ensure pre-harvest intervals of pesticides as stipulated in the products MSDS, label, security tag, or regulation by the official organization are complied with?  When two or more products with different pre-harvest intervals are used at the same time, the longest interval applies.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question20",
          "title": "\"[4.6.6] Do you ensure that mechanisms are established and maintained to avoid contamination by pesticides, through spray drift or other pathways, from treated areas to other areas including all aquatic and terrestrial natural ecosystems and infrastructure?\nSuch mechanisms include non-crop vegetative barriers, non-application zones, or other effective mechanisms.\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question21",
          "title": "[4.6.7] Do you ensure that aerial application is only allowed under the conditions outlined in Annex 7: Pesticides Management?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question22",
          "title": "\"[4.6.8] Are pesticide applications recorded? \nRecords include:* Product brand name and active ingredient(s)* Date and time of application* Location and area (size) of application* Dosage and volume* Crop* Name(s) of applicator(s)* Target pest\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question23",
          "title": "\"[4.6.9] Do you ensure that empty pesticide containers and application equipment are washed three times, and rinsing water is used in the last batch of the mix to apply to the crop? Also, do you ensure that, after the application of pesticides, application equipment is washed three times, and the surplus mix is disposed of in a way that minimizes the negative impact on the environment and human health, by diluting it with ten times the amount of clean water and applied evenly on the field that was subjected to the pesticide application?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question24",
          "title": "\"[4.6.9] Do you ensure that empty pesticide containers are kept in a locked storage area until safely disposed of through a formal collection and recycling program or returned to the supplier? If the supplier does not accept empty containers, are they cut or perforated to prevent other uses?\nDo you ensure that prohibited, obsolete, and expired pesticides are returned to the supplier or local authority? In absence of a collection system in place, are these products labeled and stored safely and separately from other products in the locked space?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question25",
          "title": "\"[4.7.1] Do you ensure the following: * Are products harvested at the right time and interval to optimize quality?* Are harvesting damages to the plant minimized for future production?* Are contamination by foreign matter, cleaning products and agrochemicals, microbes and pests prevented?* Are damages due to humidity prevented?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question26",
          "title": "\"[4.7.1] Does the farmer conserve and optimize the quality and quantity of products during harvest and post-harvest handling, including loading, processing, packing, transportation, and storage? \nThis includes:* Products are stored in a cool, dry, well-ventilated, and dark place* Maintenance and cleaning of harvest and postharvest tools, machinery, and equipment* Packaging materials are used that are suitable and approved for food products\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question27",
          "title": "[5.2.1] Do workers have the right to form and join a union or workers organization of their own choice and to take part in collective bargaining, without prior authorization from the employer, and in accordance with national law? Are workers representatives elected democratically among workers in regular, free elections?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question28",
          "title": "[5.2.2] Does the Farmer ensure that workers are not subject to discrimination or retaliation for reasons of past or present workers organization or union membership or activities? Management does not punish, bribe, or otherwise influence union members or workers representatives. Records are kept of terminations of employment, including the reason for termination and workers affiliation with a union or workers organization.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question29",
          "title": "\"[5.2.3] Does management provide workers representatives reasonable paid time off from work to carry out their representation functions and attend meetings?\nWhere needed, management provides the worker representatives with reasonable facilities including meeting space, means of communication, and child care.\nDoes management keep records of the minutes from meetings with worker organizations and/or trade unions from the survey?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question30",
          "title": "\"[5.3.1] Do you ensure that permanent and temporary workers who are employed for more than three consecutive months have a written employment contract signed by both parties? \nDoes the worker receive a copy of the contract at the time of signing? \nDo permanent and temporary workers employed for fewer than three months have at least verbal contracts in place?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question31",
          "title": "[5.3.10] Does the farmer also ensure the labor provider is; not engaged in fraudulent or coercive recruiting practices, and is compliant with applicable worker-related requirements? Are all recruitment fees paid by the farm, not by workers?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question32",
          "title": "[5.3.10] Does the farmer ensure that if labor providers are used, name, contact and, if labor provider is officially registered, official registration number of the labor provider is recorded?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question33",
          "title": "[5.3.2] Confirm with Farmer that management does not engage in arrangements or practices designed to eliminate or reduce workers pay and/or benefits such as employing temporary workers for permanent or ongoing tasks.",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question34",
          "title": "\"[5.3.3] Does the farmer ensure that workers receive at least the applicable minimum wage, or the wage negotiated in a Collective Bargaining Agreement (CBA), whichever is higher? \nFor production, quota, or piece work, the payment must be at least the minimum wage based on a 48-hour working week or national legal working hours limit, whichever is lower.\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question35",
          "title": "[5.3.5] Does Farmer ensure that In-kind benefits are in accordance with national law; however, they cannot exceed 30% of the total remuneration?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question36",
          "title": "\"[5.3.5] Does the farmer ensure that deductions from wages are permitted only if provided by national law or CBA? \nDoes the farmer also ensure that voluntary wage deductions such as advance payments, union membership, or loans can only be made with written or verbal consent from the worker?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question37",
          "title": "[5.3.5] Does the farmer ensure that wage deductions as a disciplinary measure are not allowed? Also, do you ensure that deductions for work related to tools, equipment, or gear are not allowed unless those are permitted by law?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question38",
          "title": "\"[5.3.6] Does the farmer ensure that workers are paid regularly at scheduled intervals agreed upon both by the worker and the employer but must be at least monthly?\nGroup members maintain records, per worker, of hours worked (regular and overtime) and/or volume produced, calculation of wages, in-kind benefits, and deductions. The record is signed by each worker when he/she receives payment.\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question39",
          "title": "[5.3.8] Does the farmer ensure that work of equal value is remunerated with equal pay without discrimination e.g., on gender or type of worker, ethnicity, age, color, religion, political opinion, nationality, social origin, or others?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question40",
          "title": "\"[5.5.1] Does the farmer ensure that workers do not work more than eight regular working hours per day and 48 regular working hours per week? In addition, do your workers have at least a 30-minute break after a maximum of six consecutive hours of work and are granted at least one full day of rest after a maximum of six consecutive days of work?\nDo you also ensure that the regular work hours of guards do not exceed 56 hours per week on average per year?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question41",
          "title": "[5.5.2] Does the farmer ensure that overtime work is voluntary and only permitted if it meets requirements in criterion 5.5.2 of the standard?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question42",
          "title": "\"[5.5.3] Does the farmer ensure that pregnant permanent workers are entitled to paid maternity leave of at least 14 weeks, of which a maximum of six weeks before the expected due date and at least six weeks after giving birth, and receive maternity rights and benefits?\nDo breastfeeding women have two additional 30-minute breaks per day and a space for breastfeeding to nurture the child?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question43",
          "title": "\"[5.5.4] Do you ensure that workers children younger than the applicable minimum working age who come with their parents to the workplace:* Are provided with a safe place to stay according to their age?* Are always under the supervision of adults?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question44",
          "title": "\"[5.6.10] Are all tools used by the workers in good working condition?\nDo machines have clear instructions on safe usage that can be understood by the workers and are dangerous parts guarded or encased?\nAre workers using such machines appropriately trained?\nDo you have applicable licenses for your operating machinery?\nDo you safely store machinery and other equipment when not in use?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question45",
          "title": "\"[5.6.11] Do you ensure female workers who are pregnant, nursing, or have recently given birth are not assigned to activities that pose a risk to the womans, unborn children, or infants health? In cases of job reassignment, do you ensure there is no reduction in remuneration?\nDo you ensure not to request pregnancy tests?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question46",
          "title": "[5.6.12] Are your workers allowed to leave situations with imminent danger without seeking your permission?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question47",
          "title": "\"[5.6.2] Are First aid boxes available to workers for the treatment of work-related injuries?\nThe boxes are placed at the central locations of production, processing, and maintenance sites. Trained first aid employees are present during working hours. The workers are informed where, and to whom they should go for first aid in case of emergency.\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question48",
          "title": "[5.6.3] Do the farmer and workers know where to go in case of an emergency?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question49",
          "title": "[5.6.6] Do workers always have access to safe and sufficient drinking water?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question50",
          "title": "\"[5.6.9] Do persons that work in hazardous situations (e.g., under challenging terrains, with machines, or with hazardous materials) use appropriate Personal Protective Equipment (PPE)?\nAre these persons trained in the use of the PPE and have access to the PPE free of charge?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question51",
          "title": "\"[5.7.3] Do the workers and their families that are housed or lodged on-site have safe, clean, and decent living quarters considering local conditions and the possibilities of each producer?* Access to safe drinking water* Adequate sanitary and washing facilities. Safety and privacy of vulnerable groups are ensured, at least by well-lit and lockable facilities\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            "NA"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question52",
          "title": "\"[5.8.2] Does the producer have a legal and legitimate right to use the land? In case of a dispute involving indigenous people and local communities, large farms and individually certified farms follow an FPIC process in accordance with the Rainforest Alliance FPIC Annex to attain the required conflict resolution and remediation.\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question53",
          "title": "[6.1.1] From January 1st, 2014 onward, have you ensured that natural forests and other natural ecosystems have not been converted into agricultural production or other land uses?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question54",
          "title": "[6.1.2] Do you ensure that production or processing does not occur in protected areas or their officially designated buffer zones, except where it complies with applicable law?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question55",
          "title": "[6.2.2] Do you maintain all remnant forest trees, except when these pose hazards to people or infrastructure on your farm? Do you sustainably manage other native trees on the farm and their harvesting in a way that the same quantity and quality of trees are maintained on the farm?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question56",
          "title": "[6.3.1] Do you maintain existing riparian buffers adjacent to aquatic ecosystems on your farm?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question57",
          "title": "[6.3.2] Do you maintain the additional safeguards for the protection of drinking water in case the farm is located closer than 50 m to a source of drinking water?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question58",
          "title": "\"[6.4.1] Do you ensure not to hunt, kill, fish, collect or traffick threatened animals and plants?\nAlso, do you ensure not to hunt other animals, with the following exceptions:* Producers of small farms may hunt non-threatened animals for non-commercial use only* Producers may hunt vertebrate wildlife pests on the farm only following the farms integrated\npest management (IPM) plan, and only as a measure of last resort.\nDo you ensure not to use explosives or toxic substances for hunting, fishing, or control of wildlife pests?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question59",
          "title": "\"[6.4.2] Do you ensure not to hold wildlife in captivity? \nDo you send captive wild animals that were present on the farm before the earliest certification date to professional shelters or may be held only for non-commercial purposes for the remainder of their lives? \nCaptive wild animals and farm animals are treated following the five freedom of animal welfare.\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question60",
          "title": "[6.4.3] Do you ensure not to intentionally introduce or release invasive species? Do you also ensure not to dispose of existing invasive species or their parts in aquatic ecosystems?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question61",
          "title": "[6.4.4] Do you make sure not to use wildlife for processing or harvesting any crop?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question62",
          "title": "[6.4.5] Do you prevent/reduce erosion by water and wind through practices such as re-vegetation of steep areas and terracing?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question63",
          "title": "[6.4.6] Do you make sure not to use fire for preparing or cleaning fields, except when specifically justified in the IPM plan?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question64",
          "title": "[6.6.2] Do you ensure not to use human sewage, sludge, and sewage water for production and/or processing activities?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question65",
          "title": "\"[6.6.3] Do you ensure that wastewater from processing operations is not applied to land unless it has undergone treatment to remove particulates and toxins?\nIf treated wastewater is used for irrigation, in addition to the wastewater parameters, it must comply with the wastewater parameters for irrigation.\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question66",
          "title": "\"[6.7.1] Do you ensure that waste is stored, treated, and disposed of in ways that do not pose health or safety risks to people, animals, or natural ecosystems?\nDo you also ensure that waste is stored and disposed of only in designated areas and not disposed of in natural or aquatic ecosystems? \nAre non-organic waste left on the land?\"",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question67",
          "title": "[6.7.2] Do you ensure that you do not burn waste, except in incinerators technically designed for the specific type of waste?",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "text",
          "name": "inspection_question68",
          "title": "Name of the person present during the inspection",
          "isRequired": true,
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
              "html": "<div id='location-container' style='text-align: center;'>\
              <button id='getInspectionLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button>\</div>"
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
          "title": "Signature of enumerator",
          "isRequired": true
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
//          "type": "text",
//          "name": "inspection_farmer_id",
//          "title": "Farmer ID"
//        },
//        {
//          "type": "text",
//          "name": "inspection_farmer_name",
//          "title": "Farmer name"
//        },
//        {
//          "type": "text",
//          "name": "inspection_district",
//          "title": "District"
//        },
//        {
//          "type": "text",
//          "name": "inspection_community",
//          "title": "Community"
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question1",
//          "title": "[1.2.1] Does management comply with applicable laws and collective bargaining agreements (CBA) within the scope of the Rainforest Alliance Sustainable Agriculture Standard?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question2",
//          "title": "[1.2.6] Do you keep an up-to-date list of permanent and temporary workers, containing records for each worker?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question3",
//          "title": "[1.2.9] Have you kept records for certification purposes and compliance for at least four years?",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question4",
//          "title": "[1.2.11] Is a sketch of the farm available, including the production area of certified crop, forests, water bodies, and buildings?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question5",
//          "title": "[2.1.8] Has the farmer kept sales receipts, including the name of a group member, group member ID, date, product type, and volume?",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question6",
//          "title": "\"[4.1.1] Does the farmer select plant varieties for planting, grafting, and renovation based on quality, productivity, resistance to pests and diseases, and suitability for the climate during the lifetime of the plants? Are planting materials free of pests and diseases?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question7",
//          "title": "[4.3.1] The certified crop is not genetically modified (GMO)?",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question8",
//          "title": "\"[4.4.4] Do you use organic fertilizers and by-products available at the farm level first, and supplement by inorganic fertilizer if nutrients are still lacking? \nTo minimize risk, do you make sure that animal manure is hot composted before use as a fertilizer? Do you store animal manure and compost at least 25 meters away from any water body?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question9",
//          "title": "[4.5.2] Do you regularly monitor pests and their principal natural enemies?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question10",
//          "title": "\"[4.5.3] When threshold levels of pests are reached, do you first try biological, physical, and other non-chemical control methods, and document this? \nWhen such methods are proven not to be effective, do you do agrochemical applications, as advised by a competent technician and/or upon the advice or instruction of an official national organization?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question11",
//          "title": "[4.5.4] Are you and your workers that are involved in pest management activities trained about the IPM strategy?",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question12",
//          "title": "\"[4.6.1] Do you ensure that no agrochemicals are used that are:* On the Rainforest Alliance Prohibited List?* Prohibited by applicable law?* Not legally registered in the country where the farm is? located?\nDo you use only agrochemicals sold by authorized vendors, in original and sealed packaging?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question13",
//          "title": "\"[4.6.10] Does the farmer ensure that agrochemicals and application equipment are stored in accordance with the label instructions and in a way that minimizes negative impact on the environment and human health? \nCheck whether agrochemicals are stored in their original containers or packaging\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question14",
//          "title": "\"[4.6.10] Does the farmers facility for storing agrochemicals and equipment meet ALL of the following criteria:* Dry, clean, well-ventilated?* Made from non-absorbent material?* Safely locked and accessible only by trained handlers?* Not accessible to children?* Separated from the crop, food products, and packaging materials?\"",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question15",
//          "title": "[4.6.2] If you use pesticides included on the Risk Mitigation list, do you ensure that all respective risk mitigation practices, as described in Annex 7, Pesticides Management, are implemented?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question16",
//          "title": "\"[4.6.3] Are persons handling pesticides skilled in the preparation and application of pesticides, and receive annual training?\nDo persons handling pesticides use the Personal Protective Equipment (PPE) as prescribed in the products label or Material Safety Data Sheet (MSDS)?\nIf there is no information, do you ensure that basic protective clothing with additional items is worn according to the potential risk and as recommended by a competent technician?\nIs the PPE in good condition?\nDirectly after use, are PPEs washed and stored safely and ensure it does not enter the workers housing?\nAre single-use items disposed of after one use?\nAre PPEs provided to workers free of charge?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question17",
//          "title": "[4.6.4] Do persons handling pesticides bathe, change and wash clothes after application?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question18",
//          "title": "\"[4.6.5] Are pesticides prepared and applied according to the label, MSDS, or security tag, or as recommended by an official national organization or a competent technician, especially with regards to:* Safe transport to the area of application?* Respecting the correct dosage?* Using appropriate equipment and techniques?* appropriate weather conditions?* Respecting restricted entry intervals (REI), including warning signs in the local language?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question19",
//          "title": "[4.6.5] Do you ensure pre-harvest intervals of pesticides as stipulated in the products MSDS, label, security tag, or regulation by the official organization are complied with?  When two or more products with different pre-harvest intervals are used at the same time, the longest interval applies.",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question20",
//          "title": "\"[4.6.6] Do you ensure that mechanisms are established and maintained to avoid contamination by pesticides, through spray drift or other pathways, from treated areas to other areas including all aquatic and terrestrial natural ecosystems and infrastructure?\nSuch mechanisms include non-crop vegetative barriers, non-application zones, or other effective mechanisms.\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question21",
//          "title": "[4.6.7] Do you ensure that aerial application is only allowed under the conditions outlined in Annex 7: Pesticides Management?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question22",
//          "title": "\"[4.6.8] Are pesticide applications recorded? \nRecords include:* Product brand name and active ingredient(s)* Date and time of application* Location and area (size) of application* Dosage and volume* Crop* Name(s) of applicator(s)* Target pest\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question23",
//          "title": "\"[4.6.9] Do you ensure that empty pesticide containers and application equipment are washed three times, and rinsing water is used in the last batch of the mix to apply to the crop? Also, do you ensure that, after the application of pesticides, application equipment is washed three times, and the surplus mix is disposed of in a way that minimizes the negative impact on the environment and human health, by diluting it with ten times the amount of clean water and applied evenly on the field that was subjected to the pesticide application?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question24",
//          "title": "\"[4.6.9] Do you ensure that empty pesticide containers are kept in a locked storage area until safely disposed of through a formal collection and recycling program or returned to the supplier? If the supplier does not accept empty containers, are they cut or perforated to prevent other uses?\nDo you ensure that prohibited, obsolete, and expired pesticides are returned to the supplier or local authority? In absence of a collection system in place, are these products labeled and stored safely and separately from other products in the locked space?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question25",
//          "title": "\"[4.7.1] Do you ensure the following: * Are products harvested at the right time and interval to optimize quality?* Are harvesting damages to the plant minimized for future production?* Are contamination by foreign matter, cleaning products and agrochemicals, microbes and pests prevented?* Are damages due to humidity prevented?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question26",
//          "title": "\"[4.7.1] Does the farmer conserve and optimize the quality and quantity of products during harvest and post-harvest handling, including loading, processing, packing, transportation, and storage? \nThis includes:* Products are stored in a cool, dry, well-ventilated, and dark place* Maintenance and cleaning of harvest and postharvest tools, machinery, and equipment* Packaging materials are used that are suitable and approved for food products\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question27",
//          "title": "[5.2.1] Do workers have the right to form and join a union or workers organization of their own choice and to take part in collective bargaining, without prior authorization from the employer, and in accordance with national law? Are workers representatives elected democratically among workers in regular, free elections?",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question28",
//          "title": "[5.2.2] Does the Farmer ensure that workers are not subject to discrimination or retaliation for reasons of past or present workers organization or union membership or activities? Management does not punish, bribe, or otherwise influence union members or workers representatives. Records are kept of terminations of employment, including the reason for termination and workers affiliation with a union or workers organization.",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question29",
//          "title": "\"[5.2.3] Does management provide workers representatives reasonable paid time off from work to carry out their representation functions and attend meetings?\nWhere needed, management provides the worker representatives with reasonable facilities including meeting space, means of communication, and child care.\nDoes management keep records of the minutes from meetings with worker organizations and/or trade unions from the survey?\"",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question30",
//          "title": "\"[5.3.1] Do you ensure that permanent and temporary workers who are employed for more than three consecutive months have a written employment contract signed by both parties? \nDoes the worker receive a copy of the contract at the time of signing? \nDo permanent and temporary workers employed for fewer than three months have at least verbal contracts in place?\"",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question31",
//          "title": "[5.3.10] Does the farmer also ensure the labor provider is; not engaged in fraudulent or coercive recruiting practices, and is compliant with applicable worker-related requirements? Are all recruitment fees paid by the farm, not by workers?",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question32",
//          "title": "[5.3.10] Does the farmer ensure that if labor providers are used, name, contact and, if labor provider is officially registered, official registration number of the labor provider is recorded?",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question33",
//          "title": "[5.3.2] Confirm with Farmer that management does not engage in arrangements or practices designed to eliminate or reduce workers pay and/or benefits such as employing temporary workers for permanent or ongoing tasks.",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question34",
//          "title": "\"[5.3.3] Does the farmer ensure that workers receive at least the applicable minimum wage, or the wage negotiated in a Collective Bargaining Agreement (CBA), whichever is higher? \nFor production, quota, or piece work, the payment must be at least the minimum wage based on a 48-hour working week or national legal working hours limit, whichever is lower.\"",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question35",
//          "title": "[5.3.5] Does Farmer ensure that In-kind benefits are in accordance with national law; however, they cannot exceed 30% of the total remuneration?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question36",
//          "title": "\"[5.3.5] Does the farmer ensure that deductions from wages are permitted only if provided by national law or CBA? \nDoes the farmer also ensure that voluntary wage deductions such as advance payments, union membership, or loans can only be made with written or verbal consent from the worker?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question37",
//          "title": "[5.3.5] Does the farmer ensure that wage deductions as a disciplinary measure are not allowed? Also, do you ensure that deductions for work related to tools, equipment, or gear are not allowed unless those are permitted by law?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question38",
//          "title": "\"[5.3.6] Does the farmer ensure that workers are paid regularly at scheduled intervals agreed upon both by the worker and the employer but must be at least monthly?\nGroup members maintain records, per worker, of hours worked (regular and overtime) and/or volume produced, calculation of wages, in-kind benefits, and deductions. The record is signed by each worker when he/she receives payment.\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question39",
//          "title": "[5.3.8] Does the farmer ensure that work of equal value is remunerated with equal pay without discrimination e.g., on gender or type of worker, ethnicity, age, color, religion, political opinion, nationality, social origin, or others?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question40",
//          "title": "\"[5.5.1] Does the farmer ensure that workers do not work more than eight regular working hours per day and 48 regular working hours per week? In addition, do your workers have at least a 30-minute break after a maximum of six consecutive hours of work and are granted at least one full day of rest after a maximum of six consecutive days of work?\nDo you also ensure that the regular work hours of guards do not exceed 56 hours per week on average per year?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question41",
//          "title": "[5.5.2] Does the farmer ensure that overtime work is voluntary and only permitted if it meets requirements in criterion 5.5.2 of the standard?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question42",
//          "title": "\"[5.5.3] Does the farmer ensure that pregnant permanent workers are entitled to paid maternity leave of at least 14 weeks, of which a maximum of six weeks before the expected due date and at least six weeks after giving birth, and receive maternity rights and benefits?\nDo breastfeeding women have two additional 30-minute breaks per day and a space for breastfeeding to nurture the child?\"",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question43",
//          "title": "\"[5.5.4] Do you ensure that workers children younger than the applicable minimum working age who come with their parents to the workplace:* Are provided with a safe place to stay according to their age?* Are always under the supervision of adults?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question44",
//          "title": "\"[5.6.10] Are all tools used by the workers in good working condition?\nDo machines have clear instructions on safe usage that can be understood by the workers and are dangerous parts guarded or encased?\nAre workers using such machines appropriately trained?\nDo you have applicable licenses for your operating machinery?\nDo you safely store machinery and other equipment when not in use?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question45",
//          "title": "\"[5.6.11] Do you ensure female workers who are pregnant, nursing, or have recently given birth are not assigned to activities that pose a risk to the womans, unborn children, or infants health? In cases of job reassignment, do you ensure there is no reduction in remuneration?\nDo you ensure not to request pregnancy tests?\"",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question46",
//          "title": "[5.6.12] Are your workers allowed to leave situations with imminent danger without seeking your permission?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question47",
//          "title": "\"[5.6.2] Are First aid boxes available to workers for the treatment of work-related injuries?\nThe boxes are placed at the central locations of production, processing, and maintenance sites. Trained first aid employees are present during working hours. The workers are informed where, and to whom they should go for first aid in case of emergency.\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question48",
//          "title": "[5.6.3] Do the farmer and workers know where to go in case of an emergency?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question49",
//          "title": "[5.6.6] Do workers always have access to safe and sufficient drinking water?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question50",
//          "title": "\"[5.6.9] Do persons that work in hazardous situations (e.g., under challenging terrains, with machines, or with hazardous materials) use appropriate Personal Protective Equipment (PPE)?\nAre these persons trained in the use of the PPE and have access to the PPE free of charge?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question51",
//          "title": "\"[5.7.3] Do the workers and their families that are housed or lodged on-site have safe, clean, and decent living quarters considering local conditions and the possibilities of each producer?* Access to safe drinking water* Adequate sanitary and washing facilities. Safety and privacy of vulnerable groups are ensured, at least by well-lit and lockable facilities\"",
//          "choices": [
//            "Yes",
//            "No",
//            {
//              "value": "Item 1",
//              "text": "NA"
//            }
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question52",
//          "title": "\"[5.8.2] Does the producer have a legal and legitimate right to use the land? In case of a dispute involving indigenous people and local communities, large farms and individually certified farms follow an FPIC process in accordance with the Rainforest Alliance FPIC Annex to attain the required conflict resolution and remediation.\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question53",
//          "title": "[6.1.1] From January 1st, 2014 onward, have you ensured that natural forests and other natural ecosystems have not been converted into agricultural production or other land uses?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question54",
//          "title": "[6.1.2] Do you ensure that production or processing does not occur in protected areas or their officially designated buffer zones, except where it complies with applicable law?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question55",
//          "title": "[6.2.2] Do you maintain all remnant forest trees, except when these pose hazards to people or infrastructure on your farm? Do you sustainably manage other native trees on the farm and their harvesting in a way that the same quantity and quality of trees are maintained on the farm?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question56",
//          "title": "[6.3.1] Do you maintain existing riparian buffers adjacent to aquatic ecosystems on your farm?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question57",
//          "title": "[6.3.2] Do you maintain the additional safeguards for the protection of drinking water in case the farm is located closer than 50 m to a source of drinking water?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question58",
//          "title": "\"[6.4.1] Do you ensure not to hunt, kill, fish, collect or traffick threatened animals and plants?\nAlso, do you ensure not to hunt other animals, with the following exceptions:* Producers of small farms may hunt non-threatened animals for non-commercial use only* Producers may hunt vertebrate wildlife pests on the farm only following the farms integrated\npest management (IPM) plan, and only as a measure of last resort.\nDo you ensure not to use explosives or toxic substances for hunting, fishing, or control of wildlife pests?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question59",
//          "title": "\"[6.4.2] Do you ensure not to hold wildlife in captivity? \nDo you send captive wild animals that were present on the farm before the earliest certification date to professional shelters or may be held only for non-commercial purposes for the remainder of their lives? \nCaptive wild animals and farm animals are treated following the five freedom of animal welfare.\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question60",
//          "title": "[6.4.3] Do you ensure not to intentionally introduce or release invasive species? Do you also ensure not to dispose of existing invasive species or their parts in aquatic ecosystems?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question61",
//          "title": "[6.4.4] Do you make sure not to use wildlife for processing or harvesting any crop?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question62",
//          "title": "[6.4.5] Do you prevent/reduce erosion by water and wind through practices such as re-vegetation of steep areas and terracing?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question63",
//          "title": "[6.4.6] Do you make sure not to use fire for preparing or cleaning fields, except when specifically justified in the IPM plan?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question64",
//          "title": "[6.6.2] Do you ensure not to use human sewage, sludge, and sewage water for production and/or processing activities?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question65",
//          "title": "\"[6.6.3] Do you ensure that wastewater from processing operations is not applied to land unless it has undergone treatment to remove particulates and toxins?\nIf treated wastewater is used for irrigation, in addition to the wastewater parameters, it must comply with the wastewater parameters for irrigation.\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question66",
//          "title": "\"[6.7.1] Do you ensure that waste is stored, treated, and disposed of in ways that do not pose health or safety risks to people, animals, or natural ecosystems?\nDo you also ensure that waste is stored and disposed of only in designated areas and not disposed of in natural or aquatic ecosystems? \nAre non-organic waste left on the land?\"",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "dropdown",
//          "name": "inspection_question67",
//          "title": "[6.7.2] Do you ensure that you do not burn waste, except in incinerators technically designed for the specific type of waste?",
//          "choices": [
//            "Yes",
//            "No"
//          ]
//        },
//        {
//          "type": "text",
//          "name": "inspection_inspector",
//          "title": "Name of the person present during the inspection"
//        },
//        {
//          "type": "panel",
//          "name": "location_panel",
//          "elements": [
//            {
//              "type": "text",
//              "name": "inspection_location",
//              "title": "Geolocation of farm",
//              "readOnly": true
//            },
//            {
//              "type": "html",
//              "name": "getInspectionLocation",
//              "html": "<div id='location-container' style='text-align: center;'>\
//              <button id='getInspectionLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button>\</div>"
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
//          "title": "Signature of enumerator",
//          "isRequired": true
//        }
//      ]
//    }
//  ]
//}