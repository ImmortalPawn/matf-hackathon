from sklearn import model_selection
import joblib

import sys
import simplejson as json

#['vreme', 'Temp. (ÂºC)', 'Rel. Hum. (%)', 'Pressure/ Geopot.', 'Wins speed (Km/h)', 'Clouds',
#  'Wind degrees', 'dust', 'fog', 'ice', 'mist', 'pellet', 'rain', 'shower', 'snow',
#  'thunderstorm', 'intermitt', 'continu', 'mesec', 'dan_u_nedelji']

model_forest = joblib.load("./modeli/rfr_CO_0.1.joblib")

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
    dust = data["dust"]
    fog = data["fog"]
    ice = data["ice"]
    mist = data["mist"]
    pellet = data["pellet"]
    rain = data["rain"]
    shower = data["shower"]
    mesec = data["mesec"]
    snow = data["snow"]
    thunderstorm = data["thunderstorm"]
    intermitt = data["intermitt"]
    continu = data["continu"]
    dan_u_nedelji = data["dan_u_nedelji"]
    ulaz_u_mrezu= [[vreme, temperatura, vlaznost, pritisak, brzina, oblacnost, smer_kretanja, dust, fog, \
                   ice,mist, pellet,rain,shower,snow,thunderstorm,intermitt,continu,mesec,dan_u_nedelji]]


model_forest.predict(ulaz_u_mrezu)
y_predicted = model_forest.predict(ulaz_u_mrezu)


predvidjeno_CO = {"O3": str(y_predicted[0])}
with open('./izlazi/predvidjeno_CO.txt', 'w') as f:
    json.dump(predvidjeno_CO, f, ensure_ascii=False)
