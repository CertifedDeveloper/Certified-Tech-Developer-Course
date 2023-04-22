$req = Invoke-WebRequest -Method Get -Uri https://raw.githubusercontent.com/olea/lemarios/master/nombres-propios-es.txt
$nombresConA = $req.Content.split("`n") | Where-Object { $_ -like "A*" }
$nombresConL = $req.Content.split("`n") | Where-Object { $_ -like "L*" }
$nombresSinANiL = $req.Content.split("`n") | Where-Object { $_ -notlike "[AL]*" }

$val = 0
$seleccionConA = @("0", "0", "0", "0", "0")
while ($val -le 4)
{
  $random = Get-Random -Minimum 0 -Maximum $($nombresConA.count-1)
  if (!($nombresConA[$random] -in $seleccionConA)){
      $seleccionConA[$val] = $nombresConA[$random]
      $val += 1
  }
}
foreach ($elemento in $seleccionConA)
{
  $reqGenderA = Invoke-WebRequest -Method Get -Uri https://api.genderize.io/?name=$elemento
  $reqCountryA = Invoke-WebRequest -Method Get -Uri https://api.nationalize.io/?name=$elemento
  $vPSObjectGenderA = $reqGenderA | ConvertFrom-Json
  $vPSObjectCountryA = $reqCountryA | ConvertFrom-Json
  echo "$elemento is a $($vPSObjectGenderA.gender)"
  echo "$elemento is from $($vPSObjectCountryA.country[0].country_id)"
}

$val = 0
$seleccionConL = @("0", "0", "0", "0", "0")
while ($val -le 4)
{
  $random = Get-Random -Minimum 0 -Maximum $($nombresConL.count-1)
  if (!($nombresConL[$random] -in $seleccionConL)){
      $seleccionConL[$val] = $nombresConL[$random]
      $val += 1
  }
}
foreach ($elemento in $seleccionConL)
{
  $reqGenderL = Invoke-WebRequest -Method Get -Uri https://api.genderize.io/?name=$elemento
  $reqCountryL = Invoke-WebRequest -Method Get -Uri https://api.nationalize.io/?name=$elemento
  $vPSObjectGenderL = $reqGenderL | ConvertFrom-Json
  $vPSObjectCountryL = $reqCountryL | ConvertFrom-Json
  echo "$elemento is a $($vPSObjectGenderL.gender)"
  echo "$elemento is from $($vPSObjectCountryL.country[0].country_id)"
}

$val = 0
$seleccionSinANiL = @("0", "0", "0", "0", "0")
while ($val -le 4)
{
  $random = Get-Random -Minimum 0 -Maximum $($nombresSinANiL.count-1)
  if (!($nombresSinANiL[$random] -in $seleccionSinANiL)){
      $seleccionSinANiL[$val] = $nombresSinANiL[$random]
      $val += 1
  }
}
foreach ($elemento in $seleccionSinANiL)
{
  $reqGenderSinANiL = Invoke-WebRequest -Method Get -Uri https://api.genderize.io/?name=$elemento
  $reqCountrySinANiL = Invoke-WebRequest -Method Get -Uri https://api.nationalize.io/?name=$elemento
  $vPSObjectGenderSinANiL = $reqGenderSinANiL | ConvertFrom-Json
  $vPSObjectCountrySinANiL = $reqCountrySinANiL | ConvertFrom-Json
  echo "$elemento is a $($vPSObjectGenderSinANiL.gender)"
  echo "$elemento is from $($vPSObjectCountrySinANiL.country[0].country_id)"
}