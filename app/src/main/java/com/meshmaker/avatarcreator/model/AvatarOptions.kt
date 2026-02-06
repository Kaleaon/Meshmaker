package com.meshmaker.avatarcreator.model

data class SliderSpec(
    val id: String,
    val label: String,
    val min: Float,
    val max: Float,
    val default: Float,
    val category: String
)

data class SwapPart(
    val id: String,
    val label: String,
    val category: String
)

data class ResourceLink(
    val id: String,
    val label: String,
    val description: String,
    val url: String,
    val category: String
)

object AvatarOptions {
    val sliderSpecs = listOf(
        SliderSpec("height", "Height", 0.8f, 1.2f, 1.0f, "Body Proportions"),
        SliderSpec("leg_length", "Leg Length", 0.7f, 1.3f, 1.0f, "Body Proportions"),
        SliderSpec("arm_length", "Arm Length", 0.7f, 1.3f, 1.0f, "Body Proportions"),
        SliderSpec("torso_depth", "Torso Depth", 0.7f, 1.3f, 1.0f, "Body Proportions"),
        SliderSpec("shoulder_width", "Shoulder Width", 0.7f, 1.4f, 1.0f, "Upper Body"),
        SliderSpec("chest_size", "Chest Size", 0.6f, 1.5f, 1.0f, "Upper Body"),
        SliderSpec("waist_width", "Waist Width", 0.6f, 1.4f, 1.0f, "Upper Body"),
        SliderSpec("hip_width", "Hip Width", 0.6f, 1.5f, 1.0f, "Lower Body"),
        SliderSpec("thigh_thickness", "Thigh Thickness", 0.6f, 1.5f, 1.0f, "Lower Body"),
        SliderSpec("calf_thickness", "Calf Thickness", 0.6f, 1.4f, 1.0f, "Lower Body"),
        SliderSpec("foot_size", "Foot Size", 0.6f, 1.4f, 1.0f, "Lower Body"),
        SliderSpec("neck_length", "Neck Length", 0.7f, 1.4f, 1.0f, "Head & Neck"),
        SliderSpec("head_scale", "Head Scale", 0.7f, 1.4f, 1.0f, "Head & Neck"),
        SliderSpec("jaw_width", "Jaw Width", 0.7f, 1.4f, 1.0f, "Head & Neck"),
        SliderSpec("eye_size", "Eye Size", 0.7f, 1.4f, 1.0f, "Head & Neck"),
        SliderSpec("nose_length", "Nose Length", 0.7f, 1.4f, 1.0f, "Head & Neck"),
        SliderSpec("mouth_width", "Mouth Width", 0.7f, 1.4f, 1.0f, "Head & Neck"),
        SliderSpec("ear_size", "Ear Size", 0.7f, 1.4f, 1.0f, "Head & Neck"),
        SliderSpec("hand_size", "Hand Size", 0.6f, 1.4f, 1.0f, "Hands"),
        SliderSpec("finger_length", "Finger Length", 0.6f, 1.4f, 1.0f, "Hands"),
        SliderSpec("finger_thickness", "Finger Thickness", 0.6f, 1.4f, 1.0f, "Hands"),
        SliderSpec("bicep_size", "Bicep Size", 0.6f, 1.5f, 1.0f, "Arms"),
        SliderSpec("forearm_size", "Forearm Size", 0.6f, 1.5f, 1.0f, "Arms"),
        SliderSpec("wrist_size", "Wrist Size", 0.6f, 1.4f, 1.0f, "Arms"),
        SliderSpec("skin_tightness", "Skin Tightness", 0.6f, 1.4f, 1.0f, "Detailing"),
        SliderSpec("muscle_definition", "Muscle Definition", 0.6f, 1.5f, 1.0f, "Detailing"),
        SliderSpec("body_fat", "Body Fat", 0.6f, 1.5f, 1.0f, "Detailing")
    )

    val swapParts = listOf(
        SwapPart("head_a", "Head: Classic", "Head"),
        SwapPart("head_b", "Head: Narrow", "Head"),
        SwapPart("head_c", "Head: Rounded", "Head"),
        SwapPart("torso_a", "Torso: Athletic", "Torso"),
        SwapPart("torso_b", "Torso: Slim", "Torso"),
        SwapPart("torso_c", "Torso: Heavy", "Torso"),
        SwapPart("legs_a", "Legs: Standard", "Legs"),
        SwapPart("legs_b", "Legs: Long", "Legs"),
        SwapPart("legs_c", "Legs: Short", "Legs"),
        SwapPart("hands_a", "Hands: Standard", "Hands"),
        SwapPart("hands_b", "Hands: Large", "Hands"),
        SwapPart("feet_a", "Feet: Standard", "Feet"),
        SwapPart("feet_b", "Feet: Large", "Feet"),
        SwapPart("clothes_a", "Clothes: Starter Casual", "Clothing"),
        SwapPart("clothes_b", "Clothes: Formal Set", "Clothing"),
        SwapPart("clothes_c", "Clothes: Streetwear", "Clothing")
    )

    val resourceLinks = listOf(
        ResourceLink(
            id = "outworldz_free_sculpts",
            label = "Outworldz Free Sculpt Library",
            description = "Browse free mesh, sounds, OARs/IARs, Collada, and OBJ uploads " +
                "for Second Life and OpenSim projects.",
            url = "https://outworldz.com/cgi/freesculpts.plx",
            category = "Outworldz"
        ),
        ResourceLink(
            id = "outworldz_skin_female_template",
            label = "Skin Template: Female 1",
            description = "Female skin texture template pack from Outworldz (zip).",
            url = "https://outworldz.com/cgi/sculpt-save.plx?File=/Sculpts/cgi/files/female1-skin-templates.zip",
            category = "Outworldz Skins"
        ),
        ResourceLink(
            id = "outworldz_skin_male_template",
            label = "Skin Template: Male 1",
            description = "Male skin texture template pack from Outworldz (zip).",
            url = "https://outworldz.com/cgi/sculpt-save.plx?File=/Sculpts/cgi/files/male1-skin-templates.zip",
            category = "Outworldz Skins"
        ),
        ResourceLink(
            id = "outworldz_skin_fairy_template",
            label = "Skin Template: Fairy",
            description = "Fantasy skin texture template pack from Outworldz (zip).",
            url = "https://outworldz.com/cgi/sculpt-save.plx?File=/Sculpts/cgi/files/fairy-skin-templates.zip",
            category = "Outworldz Skins"
        ),
        ResourceLink(
            id = "outworldz_clothing_male_tshirt",
            label = "Mesh Clothing: Male Cuffed Sleeve T-Shirt",
            description = "Rigged mesh clothing pack from Outworldz (zip).",
            url = "https://outworldz.com/cgi/sculpt-save.plx?File=/Sculpts/cgi/files/LindaKellieRigged-MeshClothing-MaleCuffedSleeveTshirt.zip",
            category = "Outworldz Clothing"
        ),
        ResourceLink(
            id = "outworldz_clothing_female_hoodie",
            label = "Mesh Clothing: Female Hoodie Sweater",
            description = "Rigged mesh clothing pack from Outworldz (zip).",
            url = "https://outworldz.com/cgi/sculpt-save.plx?File=/Sculpts/cgi/files/LindaKellieRigged-MeshClothing-Female-HoodieSweater.zip",
            category = "Outworldz Clothing"
        ),
        ResourceLink(
            id = "outworldz_clothing_rolled_pants",
            label = "Mesh Clothing: Rolled Pants",
            description = "Rigged mesh clothing pack from Outworldz (zip).",
            url = "https://outworldz.com/cgi/sculpt-save.plx?File=/Sculpts/cgi/files/LindaKellieRigged-MeshClothing-RolledPants.zip",
            category = "Outworldz Clothing"
        )
    )
}
