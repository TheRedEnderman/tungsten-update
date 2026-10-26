function Remove-FortuneBonus($node) {
    if ($node -is [System.Collections.IEnumerable] -and $node -isnot [string]) {
        foreach ($item in $node) { Remove-FortuneBonus $item }
        return
    }
    if ($node -is [PSCustomObject]) {
        foreach ($prop in @($node.PSObject.Properties)) {
            if ($prop.Name -in @("functions","modifier") -and $prop.Value -is [array]) {
                $filtered = @($prop.Value | Where-Object {
                    -not ($_.type -eq "minecraft:apply_bonus" -and $_.enchantment -eq "minecraft:fortune")
                })
                $node.($prop.Name) = $filtered
            }
            Remove-FortuneBonus $node.($prop.Name)
        }
    }
}

$path = Get-ChildItem -Path ".\src\main\resources\data" -Recurse -Filter "tungsten_ore.json" |
    Select-Object -First 1 -ExpandProperty FullName

Write-Host "File: $path"
Write-Host "--- PRIMA ---"
Get-Content -Path $path -Raw

$json = Get-Content -Path $path -Raw | ConvertFrom-Json
Remove-FortuneBonus $json
$json | ConvertTo-Json -Depth 20 | Set-Content -Path $path -Encoding UTF8

Write-Host "--- DOPO ---"
Get-Content -Path $path -Raw

git add -A
git commit -m "Actually remove Fortune bonus from tungsten ore (nested under alternatives/modifier)"
git push origin main
