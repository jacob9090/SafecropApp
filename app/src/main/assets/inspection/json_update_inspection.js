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
          "title": "[1.2.6] Do you keep an up-to-date list of permanent and temporary workers, containing records for each worker?\r\n",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question3",
          "title": "[1.2.9] Have you kept records for certification purposes and compliance for at least four years?\n",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            {
              "value": "Item 1",
              "text": "NA"
            }
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question4",
          "title": "[1.2.11] Is a sketch of the farm available, including the production area of certified crop, forests, water bodies, and buildings?\r\n",
          "isRequired": true,
          "choices": [
            "Yes",
            "No"
          ]
        },
        {
          "type": "dropdown",
          "name": "inspection_question5",
          "title": "[2.1.8] Has the farmer kept sales receipts, including the name of a group member, group member ID, date, product type, and volume?\r\n",
          "isRequired": true,
          "choices": [
            "Yes",
            "No",
            {
              "value": "Item 1",
              "text": "NA"
            }
          ]
        },
        {
          "type": "panel",
          "name": "location_panel",
          "elements": [
            {
              "type": "text",
              "name": "inspection_location",
              "title": "Geolocation of farm",
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
          "title": "Farmer thumbprint\n",
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