#!/bin/bash
req=`curl https://raw.githubusercontent.com/olea/lemarios/master/nombres-propios-es.txt | shuf`

countA=0

for nombre in $req
do
    if [[ $nombre == A* ]] && [ $countA -le 4 ];
    then
        curl -s https://api.genderize.io/?name=$nombre | jq '.gender' | { read -r gen; echo "El genero de $nombre es: $gen";}        
        curl -s https://api.nationalize.io/?name=$nombre | jq '.country[0].country_id' | { read -r cn; echo "El pais de $nombre es: $cn";}        
        let "countA++"
    fi
done

countL=0

for nombre in $req
do
    if [[ $nombre == L* ]] && [ $countL -le 4 ];
    then
        curl -s https://api.genderize.io/?name=$nombre | jq '.gender' | { read -r gen; echo "El genero de $nombre es: $gen";}        
        curl -s https://api.nationalize.io/?name=$nombre | jq '.country[0].country_id' | { read -r cn; echo "El pais de $nombre es: $cn";}        
        let "countL++"
    fi
done

countNoAL=0

for nombre in $req
do
    if [[ $nombre != A* ]] && [[ $nombre != L* ]] && [ $countNoAL -le 4 ];
    then
        curl -s https://api.genderize.io/?name=$nombre | jq '.gender' | { read -r gen; echo "El genero de $nombre es: $gen";}        
        curl -s https://api.nationalize.io/?name=$nombre | jq '.country[0].country_id' | { read -r cn; echo "El pais de $nombre es: $cn";}        
        let "countNoAL++"
    fi
done