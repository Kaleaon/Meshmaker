# Avatar Asset Pipeline Design Doc

## Overview
This document defines the recommended avatar asset pipeline for creating production-ready, engine-compatible characters. It covers modeling, rigging/skin weights, texturing/shading, and export targets, plus acceptance criteria for final delivery.

## Modeling Tools and File Formats
**Preferred tools**
- **Blender** for general modeling, retopology, and layout.
- **ZBrush** for high-poly sculpting and detail passes.

**Working formats**
- **Blend** (`.blend`) for iterative work and scene setup.
- **ZTL/ZPR** for sculpt source files.

**Exchange formats**
- **FBX** (`.fbx`) for rigged meshes and animation interchange.
- **GLB/GLTF** (`.glb`/`.gltf`) for engine previews and lightweight validation.

## Rigging and Skin Weights Workflow
### Second Life / OpenSim base assets
When building starter meshes, **download and use the standard Second Life avatar body + skeleton** as the baseline rig. Use **open source OpenSim meshes and resources** as supplemental references for topology and weighting. Keep all assets in a clearly labeled `source/` folder and record license/attribution in the project notes. See the Drive asset inventory and download steps in `docs/asset_library.md`.

**Recommended sources**
- **Second Life (SL) avatar skeleton and body**: Use the official SL avatar skeleton/shape resources from Linden Lab or community documentation, ensuring the bone names and joint orientations match SL defaults. The Drive library includes `SecondLifeAvatarSkeleton.zip` with male and female skeletons in Blend/DAE/FBX/MA formats.
- **OpenSim (Open Simulator) open source meshes**: Prefer OpenSim community avatar meshes and compatible skeletons that are explicitly open source. Verify licenses and attribution requirements before importing.

**Practical guidance**
- Preserve **SL bone names and hierarchy** to maintain compatibility with existing SL animations.
- Retain **default joint positions** unless you have a documented reason to adjust them (and document any adjustments).
- Use OpenSim mesh topology as a **reference** for clean deformation and LODs, but keep the final rig aligned to SL defaults.
- Validate imports in Blender with a known-good SL animation set to confirm compatibility.
- Build **shape sliders** that deform the standard SL skeleton into varied shapes (height, leg length, arm length, torso depth, head scale, hand size). Use Blender shape keys (or equivalent) tied to exportable sliders so creators can dial between extremes while preserving SL bone names, hierarchy, and animation compatibility.
- For automated slider setup, follow `docs/shape_key_matching.md` to batch-transfer and validate shape keys between reference and target meshes.

1. **Base rig creation**
   - Use **Mixamo** or **Auto-Rig Pro** for initial biped rig generation.
   - Ensure a consistent naming convention for bones (e.g., `Hips`, `Spine`, `Neck`, `Head`, `LeftArm`, `RightArm`).
2. **Manual cleanup pass**
   - Verify joint placement and orientation in Blender.
   - Rebuild or reorient problematic joints as needed for deformation quality.
3. **Skin weighting**
   - Start from auto-generated weights.
   - Perform **manual cleanup** on elbows, knees, shoulders, and facial areas to reduce pinching.
   - Validate deformation with a basic animation set (walk, run, arms up, crouch).
4. **Rig validation**
   - Confirm compatibility with engine retargeting profiles.
   - Ensure root motion and scale are consistent (1.0 scale, meters).

## Texture and Shader Workflow
**Texture layout**
- Use **UDIMs** for high-resolution characters when needed (e.g., `1001` body, `1002` head).
- For lightweight avatars, use a **single UV set** with a single 0–1 UV tile.

**PBR maps**
- Base Color (Albedo)
- Normal (Tangent space)
- Roughness
- Metallic
- Ambient Occlusion

**Skin shading**
- Use **Subsurface Scattering (SSS)** with separate **SSS Color** or **Thickness** maps if supported.
- Include **wrinkle maps** (normal + mask) for facial expressions or pose-driven wrinkles.

**Resolution guidance**
- Hero character: 4K textures (UDIMs allowed)
- NPC/secondary: 2K textures
- Crowd/LOD: 1K or lower

## Export Targets and LODs
**Engine targets**
- **Unreal Engine**: FBX with skeletal mesh, animations in separate FBX files.
- **Unity**: FBX for skeletal mesh and animations, optional GLB for preview.
- **Web**: GLB (binary GLTF) with compressed textures when possible.

**LODs**
- Deliver **LOD0–LOD2** at minimum.
- Generate LODs by reducing vertex count and simplifying materials (merge texture sets where appropriate).

## Pipeline Acceptance Checklist
Use this checklist to approve a character asset for delivery:

- [ ] **Vertex count limit** meets target budget:
  - LOD0: ≤ 60k vertices
  - LOD1: ≤ 30k vertices
  - LOD2: ≤ 15k vertices
- [ ] **Rig compatibility**:
  - Bone naming matches engine retargeting profile
  - Root bone at origin, correct orientation
  - No non-uniform scale on bones
- [ ] **Skin weighting quality**:
  - No visible pinching or collapsing at joints
  - Deformation passes basic animation tests
- [ ] **Texture size budget**:
  - Hero: ≤ 4K
  - NPC: ≤ 2K
  - Crowd/LOD: ≤ 1K
- [ ] **Shader compliance**:
  - PBR maps present and correctly packed
  - SSS and wrinkle maps included when required
- [ ] **Export integrity**:
  - FBX/GLB imports cleanly in target engine
  - LODs present and correctly ordered
