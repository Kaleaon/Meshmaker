# Asset Library (Drive Import)

This project uses a shared Google Drive asset library for starter meshes, skeletons, and reference models. **Download the full library** and keep it in a local `source/drive_assets/` folder so it is available during modeling, rigging, and validation.

## Download instructions
1. Install the downloader:
   - `pip install gdown`
2. Download the entire folder:
   - `gdown --folder https://drive.google.com/drive/folders/1kLjcQWGdNt41RIxdAgeIL5qmLFHqcgea -O source/drive_assets`

## Required baseline assets
These assets are mandatory for starter mesh work:
- **SecondLifeAvatarSkeleton.zip**  
  Use `Skeleton.Male.*` and `Skeleton.Female.*` as the **baseline SL skeleton** in Blender/FBX/DAE workflows.

## Asset inventory (Drive folder)
Use these as reference meshes, anatomical guides, or accessory sources as appropriate for the project scope. Confirm license and attribution for every asset before use.

- `6ndltocgxk74-Male_Base_Mesh_Arshlevon_Sizes.zip`
- `27-blender.rar`
- `88-blend.rar`
- `angelica.glb`
- `animal_skull_wk5idfu_gltf_high.zip`
- `anthro_female_canine_base.glb`
- `anthro_male_feline_base.glb`
- `base_mesh_pack_free.glb`
- `basemash_female_facetypec.glb`
- `DrakoTPOSE.zip`
- `femalebasemeshtextures.zip`
- `lizard_kin_warrior_character_rig_gltf.zip`
- `male_base_muscular_anatomy.zip`
- `male_fashion_hair_collection_08_lowpoly_haircard_gltf.zip`
- `malebasemeshcharacters_pack_gltf.zip`
- `minotaur.glb`
- `minotaur_bust.glb`
- `monster_orc.glb`
- `realtime_male_fashion_hair_collection_07_gltf.zip`
- `super_human.zip`

## Usage guidance
- Treat all Drive assets as **source references**: avoid shipping them directly unless the license explicitly allows redistribution.
- Preserve the **Second Life bone naming and hierarchy** when adapting meshes for SL/OpenSim compatibility.
- Prefer OpenSim-compatible meshes (when identified and licensed) for topology/weighting reference, while keeping the final rig aligned to SL defaults.
- Record provenance and license details in your project notes for each asset you use.
