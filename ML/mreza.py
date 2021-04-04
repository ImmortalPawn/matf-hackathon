import keras.models

import sys
import simplejson as json


model = keras.models.load_model('./modeli/prt10.43.hdf5')


#"vreme" , "temperatura", "vlaznost", "pritisak", "brzina", "oblacnost", "dan u nedelji" , "mesec"

args = sys.argv
path_json = args[1]

with open(path_json) as json_file:
    data = json.load(json_file)
    vreme = data["vreme"]
    temperatura = data["temperatura"]
    vlaznost = data["vlaznost"]
    pritisak = data["pritisak"]
    brzina = data["brzina"]
    oblacnost = data["oblacnost"]
    dan_u_nedelji = data["dan u nedelji"]
    mesec = data["mesec"]
    ulaz_u_mrezu= [[vreme, temperatura, vlaznost, pritisak, brzina, oblacnost, dan_u_nedelji, mesec]]

y_predicted = model.predict(ulaz_u_mrezu)


predvidjeno_cestica = {"PM10": str(y_predicted[0][0])}
with open('./izlazi/predvidjanje.txt', 'w') as f:
    json.dump(predvidjeno_cestica, f, ensure_ascii=False)
