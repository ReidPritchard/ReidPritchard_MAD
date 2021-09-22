//
//  ViewController.swift
//  lab_03
//
//  Created by Reid Pritchard on 9/22/21.
//

import UIKit

class ViewController: UIViewController {
    let images: [UIImage] = [UIImage(imageLiteralResourceName: "cuteSheep"), UIImage(imageLiteralResourceName: "coolSheep")]
    let captions = ["A super cute baby babydoll sheep", "A super cool sheep"]
    
    @IBOutlet weak var image_container: UIImageView!
    @IBOutlet weak var image_label: UILabel!
    @IBOutlet weak var segment_controller: UISegmentedControl!
    @IBOutlet weak var font_slider: UISlider!
    @IBOutlet weak var capital_switch: UISwitch!
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        update_all()
    }
    
    func update_all() {
        let index = segment_controller.selectedSegmentIndex
        let font_size = CGFloat(font_slider.value)
        let isCaps = capital_switch.isOn

        
        image_container.image = images[index]
        
        image_label.text = isCaps ? captions[index].uppercased() : captions[index]
        image_label.font = UIFont(name: "systemFont", size: font_size)
        
        image_label.textColor = index == 0 ? .blue : .red
        
        font_slider.tintColor = index == 0 ? .blue : .red
        capital_switch.onTintColor = index == 0 ? .blue : .red
    }

    @IBAction func segment_updated(_ sender: Any) {
        update_all()
    }
    
    @IBAction func font_size_changed(_ sender: Any) {
        update_all()
    }
    
    @IBAction func caps_changed(_ sender: Any) {
        update_all()
    }
    
}

