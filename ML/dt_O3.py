from sklearn import model_selection
import joblib

import sys
import simplejson as json

#['vreme', 'Temp. (ÂºC)', 'Rel. Hum. (%)',
#'Pressure/ Geopot.', 'Wins speed (Km/h)', 'Clouds', 'Wind degrees', 'mesec']

model_forest = joblib.load("./modeli/rfr_o3_224.joblib")

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
    smer_kretanja = data["smer kretanja"]
    mesec = data["mesec"]
    ulaz_u_mrezu= [[vreme, temperatura, vlaznost, pritisak, brzina, oblacnost, smer_kretanja, mesec]]


y_predicted = model_forest.predict(ulaz_u_mrezu)


predvidjeno_o3 = {"O3": str(y_predicted[0])}
with open('./izlazi/predvidjanje_o3.txt', 'w') as f:
    json.dump(predvidjeno_o3, f, ensure_ascii=False)
