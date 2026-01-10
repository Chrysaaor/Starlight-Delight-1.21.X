data get entity @s SelectedItem

execute if entity @s[nbt={SelectedItem:{id:"starlightdelight:starlight_hoe"}}] unless predicate farm3:is_sneaking at @s anchored eyes positioned ^ ^ ^2 at @e[type=item,distance=..2,nbt={Age:0s}] run function #harvest
execute if entity @s[nbt={SelectedItem:{id:"starlightdelight:hoely_beheader"}}] unless predicate farm3:is_sneaking at @s anchored eyes positioned ^ ^ ^2 at @e[type=item,distance=..2,nbt={Age:0s}] run function #harvest
scoreboard players set @s farm3_wheatmined 0
scoreboard players set @s farm3_carrotsmined 0
scoreboard players set @s farm3_potatoesmined 0
scoreboard players set @s farm3_beetrootsmined 0
scoreboard players set @s farm3_netherwartmined 0
scoreboard players set @s farm3_cauliflowermined 0