const json = {
  "pages": [
    {
      "name": "page1",
      "elements": [
        {
          "type": "dropdown",
          "name": "district",
          "title": "Name of district.",
          "isRequired": true,
          "choices": [
           "Bechem",
            "Tepa"
          ]
        },
        {
          "type": "dropdown",
          "name": "community",
          "title": " Select community",
          "isRequired": true,
          "choices": [
            "Abechem",
            "Apesika",
            "Appiahkrom",
            "Asenchem",
            "Bomaa",
            "Brosankro",
            "Derma",
            "Derma Nkwankyire",
            "Dumakwai",
            "Dwomo",
            "Jacobu",
            "Katapei",
            "Kisuogya",
            "Kramokrom",
            "Kruboa",
            "Kusuogya",
            "Kwaku Dua krom",
            "Kyekyewere",
            "Mampong",
            "Old Town",
            "Pokuakura",
            "Submpang",
            "Subompan",
            "Subompang",
            "Subonpang",
            "Tanokrom",
            "Techimantia",
            "Tepa"
          ]
        },
        {
          "type": "dropdown",
          "name": "graquestion1",
          "title": "Has the cooperative/association management NOT already taken any actions to prevent violence and harassment, including sexual harassment, among members and workers?  \r\n",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "graquestion2",
          "title": "Has the cooperative/association management or the HRDD Committee NOT taken actions to address gender and/or women's empowerment for at least one year?\r\n",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "graquestion3",
          "title": "Do female members represent less than 25% of the total number of cooperative/association members? \r\n",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "graquestion4",
          "title": "Are women currently less than 25% of trainers, supervisors, management staff and/or other high skilled functions at the cooperative/association?\r\n",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "graquestion5",
          "title": "Are female workers or members currently less than 25% of total participants in training?\r\n",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "dropdown",
          "name": "graquestion6",
          "title": "Do wives of male members or other female family workers NOT participate in training activities?\r\n",
          "choices": [
            "Yes",
            "No"
          ],
          "showNoneItem": true
        },
        {
          "type": "panel",
          "name": "location_panel",
          "elements": [
            {
              "type": "text",
              "name": "gra_location",
              "title": "Geo - Location",
              "readOnly": true
            },
            {
              "type": "html",
              "name": "getGraLocation",
              "html": "<div id='location-container' style='text-align: center;'>\
              <button id='getGraLocation' style='width: 100%; background-color: brown; color: white; display: block; margin: 0 auto;' type='button' onclick='handleGetLocation()'>Get Location</button>\</div>"
            }
          ]
        },
        {
          "type": "panel",
          "name": "photo_panel",
          "title": "Photo of community",
          "elements": [
            {
              "type": "html",
              "name": "gra_photo",
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
          "title": "Signature of field agent",
          "isRequired": true
        }
      ]
    }
  ]
}