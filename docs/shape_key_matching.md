# Automated Shape Key Matching Setup

This guide describes a **repeatable, automated** workflow to transfer and align shape keys from a source mesh (reference) to a target mesh (working avatar). The goal is consistent slider behavior across varied bodies while preserving the **Second Life skeleton** naming, hierarchy, and compatibility.

## Prerequisites
- Blender 3.x+
- Source mesh with shape keys (reference)
- Target mesh with matching topology **or** a clean, consistent retopo that can be wrapped
- SL skeleton (male/female) from the Drive library (`SecondLifeAvatarSkeleton.zip`)

## Automated setup (Blender)
Use the following automation sequence to match and transfer shape keys:

1. **Normalize transforms**
   - Apply scale/rotation on both meshes (`Ctrl+A → All Transforms`).
   - Ensure both meshes are in the same world position and orientation.

2. **Name harmonization**
   - Ensure the target mesh has **no duplicate shape key names**.
   - Normalize names to a consistent slider set (e.g., `Height`, `ArmLength`, `LegLength`, `TorsoDepth`, `HeadScale`, `HandSize`).

3. **Automated shape key transfer**
   - Use Blender’s **Data Transfer** modifier or a script to transfer shape key deltas from source → target.
   - Prefer **Topological** mapping when topology matches; otherwise use **Nearest Surface Point** with a pre-wrapped target.

4. **Slider validation batch**
   - Auto-run a validation pass that steps each slider to min/max and checks for extreme distortions.
   - Flag shape keys that exceed deformation thresholds for manual cleanup.

## Example Python automation (Blender)
Save this as `scripts/shape_key_transfer.py` and run inside Blender’s Scripting tab:

```python
import bpy

SOURCE = "SourceMesh"
TARGET = "TargetMesh"

src = bpy.data.objects[SOURCE]
tgt = bpy.data.objects[TARGET]

for key in src.data.shape_keys.key_blocks:
    if key.name == "Basis":
        continue
    if key.name not in tgt.data.shape_keys.key_blocks:
        tgt.shape_key_add(name=key.name, from_mix=False)

    bpy.ops.object.select_all(action="DESELECT")
    src.select_set(True)
    tgt.select_set(True)
    bpy.context.view_layer.objects.active = tgt
    bpy.ops.object.shape_key_transfer()
```

## Output expectations
- Target mesh receives a **consistent slider set** aligned to SL proportions.
- All shape keys remain editable and can be exported in FBX/DAE for downstream tools.
- Final rig stays compatible with SL/OpenSim animation sets.
